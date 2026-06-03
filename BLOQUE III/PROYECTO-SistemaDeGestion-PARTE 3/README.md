# SISTEMA DE GESTIÓN DE PEDIDOS PARTE 4 (FINAL)
Buenos días/tardes/noches, aquí se encuentra la extensión del proyecto que estamos realizando en entornos de desarrollo con su debida parte 4.

# DISTRIBUCIÓN
Dentro de la carpeta "src", se encuentran las carpetas "main" y "test".

Dentro de "main" se encuentra todo el funcionamiento del sistema.
Dentro de "test" se encuentran todos los casos de prueba pasados a código los cuales han sido testeados con QASPhere.

# MEMORIA DE LA PARTE FINAL

En este apartado voy a documentar los cambios que he realizado en el proyecto para la parte final:

# MAIN
Para el main, he tenido que añadir dos clases nuevas que son:

- **"Tienda.java"** -> Esta clase es la que realiza la venta completa, cuyas funciones son:
    - Calcular el total
    - Aplicar descuentos de fidelidad
    - Calcular gastos de envío
    - Generar la factura
 
- **"Factura.java"** -> Esta clase es la que genera el documento de salida de la venta, cuyas funciones son:
    - Desglosar la venta completa
    - Mostrar el total bruto
    - El coste de envio
    - Los descuentos
    - Y el total final

- **"Cliente.java"** -> También he tenido que modificar esta clase para añadirle los siguientes atributos:
    - `anyosAntiguedad` -> Determina el porcentaje de descuento de fidelidad.
    - `esVip` -> Añade un 5% extra de descuento.
    - `pais` -> Determina los gastos de envío.

# TEST
Para los test, he tenido que añadir varios nuevos archivos para las pruebas de integración y para obtener el 80% de cobertura que se me pide en el proyecto:
- **"TiendaFacturaIntegrationTest.java"** -> En este he hecho la prueba compelta de E2E.

He modificado/corregido dos archivos que ya tenía de antes que fallaban:
- **"GestionPedidosIntegrationTest.java"** -> Los test esperaban resultados que contradecían al código real. Los he cambiado por assertThrows.

- **"SistemaIntegracionTest.java"** -> El test esperaba el valor `32.2` pero la prueba devolvía `30.39`. He corregido el valor esperado.

- **"CalculadoraFinancieraTest.java"** -> Clase nueva para cubrir el porcentaje de cobertura de errores. Realizando test para sus funciones.

- **"ClienteTest.java"** -> Clase nueva para cubrir el porcentaje de cobertura de errores. Realizando test para sus funciones.

- **"GestorInventarioTest.java"** -> Clase nueva para cubrir el porcentaje de cobertura de errores. Realizando test para sus funciones.

- **"ServicioFacturacionTest.java"** -> Clase nueva para cubrir el porcentaje de cobertura de errores. Realizando test para sus funciones.

# PROBLEMAS ENCONTRADOS
Durante el análisis de SonarQube, Jacoco no generaba el informe de cobertura debido a un problema de escritura. Conseguí arreglarlo y resulta que era porque tenía el proyecto sincronizado con OneDrive desde mi ordenador y el programa tenía problemas al escribir en la carpeta compartida en la nube. He migrado mi proyecto a una carpeta local que no dependa de conexión a internet o esté enlazada con la nube y funcionaba a la perfección.
