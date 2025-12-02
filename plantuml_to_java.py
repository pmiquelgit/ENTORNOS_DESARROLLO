import re
import os
import sys

def generate_java_code(puml_content, output_dir="src/main/java"):
    """
    Parses PlantUML content and generates Java source files.

    Args:
        puml_content (str): The content of the PlantUML file.
        output_dir (str): The base directory where generated Java files will be placed.
                          Defaults to "src/main/java".
    """
    java_code_map = {}
    current_package = None

    # --- 1. Identify Package ---
    package_match = re.search(r'package "([^"]+)"', puml_content)
    if package_match:
        current_package = package_match.group(1)
        package_path = current_package.replace('.', os.sep)
        # Ensure output directory exists, including package structure
        target_output_dir = os.path.join(output_dir, package_path)
        os.makedirs(target_output_dir, exist_ok=True)
    else:
        # If no package is defined, use the base output directory
        target_output_dir = output_dir
        os.makedirs(target_output_dir, exist_ok=True) # Ensure base output dir exists

    # --- 2. Parse Classes, Interfaces, Enums ---
    item_pattern = re.compile(
        r'(?P<modifiers>abstract)?\s*(?P<type>class|interface|enum)\s+(?P<name>\w+)\s*'
        r'(?:extends\s+(?P<extends>[\w,\s]+))?\s*'
        r'(?:implements\s+(?P<implements>[\w,\s]+))?\s*{\s*(?P<body>.*?)\s*}',
        re.DOTALL | re.IGNORECASE
    )

    # Also handle relationships defined *outside* the class block
    relationships = re.findall(r'(\w+)\s*<\|\-\-\s*(\w+)', puml_content)
    # Implementation: Implementer <|.. Interface (e.g., Customer <|.. Orderable)
    interface_relationships = re.findall(r'(\w+)\s*<\|\.\.\s*(\w+)', puml_content)

    # First step: Collect basic info and relationships
    parsed_items = {}
    for match in item_pattern.finditer(puml_content):
        modifiers = match.group('modifiers')
        item_type = match.group('type').lower()
        item_name = match.group('name')
        item_body = match.group('body').strip()
        explicit_extends = match.group('extends')
        explicit_implements = match.group('implements')

        parsed_items[item_name] = {
            'type': item_type,
            'is_abstract': bool(modifiers and modifiers.lower() == 'abstract'),
            'body': item_body,
            'extends': [e.strip() for e in explicit_extends.split(',')] if explicit_extends else [],
            'implements': [i.strip() for i in explicit_implements.split(',')] if explicit_implements else [],
            'java_code': "" # Placeholder for generated code
        }

    # Second step: Apply relationships from outside the block
    # This is important if extends/implements are defined via arrows.
    for implementer, interface_name in interface_relationships:
        if implementer in parsed_items and interface_name not in parsed_items[implementer]['implements']:
            parsed_items[implementer]['implements'].append(interface_name)

    for child, parent in relationships:
        if child in parsed_items and parent not in parsed_items[child]['extends']:
            parsed_items[child]['extends'].append(parent)


    # --- 3. Generate Java Code for each Item ---
    for item_name, item_data in parsed_items.items():
        item_type = item_data['type']
        is_abstract = item_data['is_abstract']
        item_body = item_data['body']
        extends_list = item_data['extends']
        implements_list = item_data['implements']

        java_output = ""
        if current_package:
            java_output += f"package {current_package};\n\n"

        # Class/Interface/Enum declaration line
        if item_type == "class":
            abstract_modifier = "abstract " if is_abstract else ""
            java_output += f"public {abstract_modifier}class {item_name}"
            # Java classes can only extend one class
            if extends_list:
                java_output += f" extends {extends_list[0]}" # Take first if multiple somehow specified
            if implements_list:
                java_output += f" implements {', '.join(implements_list)}"
            java_output += " {\n"
        elif item_type == "interface":
            java_output += f"public interface {item_name}"
            # Java interfaces can extend multiple interfaces
            if extends_list:
                java_output += f" extends {', '.join(extends_list)}"
            java_output += " {\n"
        elif item_type == "enum":
            java_output += f"public enum {item_name} \n"
            enum_values = [v.strip() for v in item_body.split('\n') if v.strip()]
            if enum_values:
                # Add a semicolon at the end of enum values, as methods might follow
                java_output += "    " + ",\n    ".join(enum_values) + ";\n"
            java_output += "\n"
            java_code_map[item_name] = java_output
            continue # Skip normal member processing for enums

        # Process members (attributes and methods)
        members = item_body.split('\n')
        for member_line in members:
            member_line = member_line.strip()
            if not member_line or member_line == "--": # Skip empty lines or PlantUML separators
                continue

            # Visibility: +, #, -, ~ (public, protected, private, package-private)
            visibility_char = member_line[0]
            visibility = "private" # Default to private
            if visibility_char == '+': visibility = "public"
            elif visibility_char == '#': visibility = "protected"
            elif visibility_char == '~': visibility = "" # Package-private (no keyword in Java)

            member_line = member_line[1:].strip() # Remove visibility char

            # Attributes
            attr_match = re.match(r'^(?P<name>\w+)\s*:\s*(?P<type>[\w\.<>\[\]]+)$', member_line)
            if attr_match:
                attr_name = attr_match.group('name')
                attr_type = attr_match.group('type')
                java_output += f"    {visibility} {attr_type} {attr_name};\n"
            # Methods
            else:
                method_match = re.match(r'^(?P<name>\w+)\((?P<params>.*?)\)(?::\s*(?P<return_type>[\w\.<>\[\]]+))?$', member_line)
                if method_match:
                    method_name = method_match.group('name')
                    params_str = method_match.group('params')
                    return_type = method_match.group('return_type') if method_match.group('return_type') else "void"

                    java_params = []
                    if params_str:
                        for param_pair in params_str.split(','):
                            param_pair = param_pair.strip()
                            if not param_pair: continue
                            if ':' in param_pair: # e.g., 'subject: String'
                                p_name, p_type = param_pair.split(':', 1)
                                java_params.append(f"{p_type.strip()} {p_name.strip()}")
                            else: # e.g., 'String arg' or just 'arg'. Fallback if no colon.
                                # This is a best-effort parse for param without explicit type:name
                                parts = param_pair.split()
                                if len(parts) == 2: # Likely "Type name"
                                    java_params.append(f"{parts[0]} {parts[1]}")
                                else: # Just "name", or other ambiguous format. Default to Object
                                    java_params.append(f"Object {param_pair}") # Fallback
                    java_params_str = ", ".join(java_params)

                    method_declaration = f"    {visibility} {return_type} {method_name}({java_params_str})"
                    # Abstract methods in interfaces or abstract classes don't have a body
                    if item_type == "interface" or is_abstract:
                        java_output += method_declaration + ";\n"
                    else:
                        java_output += method_declaration + " {\n        // TODO: Implementar el método\n    }\n"
        java_output += "}\n"
        java_code_map[item_name] = java_output

    # --- 4. Write Files to Disk ---
    for class_name, code in java_code_map.items():
        filename = f"{class_name}.java"
        # Determine the correct path based on whether a package was found
        file_path = os.path.join(target_output_dir, filename)
        with open(file_path, "w") as f:
            f.write(code)
        print(f"Generado: {file_path}")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python plantuml_to_java.py <plantuml_file_path> [output_directory]")
        sys.exit(1)

    puml_file = sys.argv[1]
    # Default output directory assumes a standard Maven/Gradle project structure
    # You can specify a different one as the second argument
    output_dir = sys.argv[2] if len(sys.argv) > 2 else "src/main/java"

    try:
        with open(puml_file, 'r') as f:
            puml_content = f.read()
        generate_java_code(puml_content, output_dir)
    except FileNotFoundError:
        print(f"Error: Fichero PlantUML '{puml_file}' no encontrado.")
        sys.exit(1)
    except Exception as e:
        print(f"Error inesperado: {e}")
        sys.exit(1)