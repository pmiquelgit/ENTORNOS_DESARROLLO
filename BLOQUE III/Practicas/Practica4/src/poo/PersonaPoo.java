package poo;

public class PersonaPoo {

    /**
     * Definicion de atributos de la persona
     */

    private String nombre;
    private int edad;
    private String direccion;
    private String apellidos;
    private String dni;
    private String email;
    private String telefono;
    private String profesion;
    private int annoExperiencia;
    /**
     * Definicion del comportamiento de la persona
     */
    public PersonaPoo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = "";
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.profesion = profesion;
        this.annoExperiencia = annoExperiencia;
    }

    //MÉTODO PARA MOSTRAR INFORMACIÓN DE LA CLASE PERSONA
    public void mostrarInformacion() {

        System.out.println("Nombre: " + this.nombre + " y edad: " + this.edad + " en la dirección: " + this.direccion);

    }

    //UN OBJETO PARA ESTABLECER Y RECIBIR EL NOMBRE DE UN ALUMNO
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER LA EDAD DEL ALUMNO
    public void setEdad (int edad) {
        this.edad = edad;
    }
    
    public int getEdad() {
        return this.edad;
    }

    //UN OBJETO PARA ESTABLECER Y RECIBIR EL APELLIDO DE UN ALUMNO
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER EL DNI
    public void setdni(String dni) {
        this.dni = dni;
    }

    public String getdni() {
        return this.dni;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER EL EMAIL  DEL ALUMNO
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER EL TELEFONO DEL ALUMNO
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER LA PROFESION
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getProfesion() {
        return this.profesion;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER LOS AÑOS DE EXPERIENCIA
    public int getAnnoExperiencia() {
        return this.annoExperiencia;
    }

    public void setAnnoExperiencia(int annoExperiencia) {
        this.annoExperiencia = annoExperiencia;
    }

    //UN OBJETO PARA ESTABLECER Y RECOGER LA DIRECCION DEL ALUMNO
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    //MÉTODO PARA SABER SI LA PERSONA ESTÁ JUBILADA O NO
    public boolean estaJubilado() {
        if (this.edad > 65) {
            System.out.println("La persona en cuestión se encuentra jubilad@.");
            return true;
        } else {
            if (this.edad >= 18) {
                System.out.println("La persona en cuestión está en edad para trabajar.");

            } else {
                System.out.println("La persona es menos y no puede trabajar.");
            }
            return false;
        }
    }
}
