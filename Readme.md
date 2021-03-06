Sistema de agenda para gestionar eventos y actividades, gestionado usuarios.

EJECUCION DEL PROYECTO.

- BASE DE DATOS

     - puede valerse de los script proporcionados en la carpeta 'BaseDatos Script', encontrara codigo sql para crear la base de datos, que creara las tablas, secuencias, insercion de datos, y demas recursos.

     - (OPCIONAL) Otra opcion es modificar el archivo  'application.properties' en la ruta 'src/main/resources',  puede agragar las configuraciones y credenciales a su servidor de base de datos, si desea aplicar ingnieria inversa, y crear tablas a partir de las clases modelos agregar o descomentar la siguiente instruccion: spring.jpa.hibernate.ddl-auto = create

- DEPLOY

    - Instalar dependencias de Maven.
    
    - Utilizar un IDE o editor de codigo que tenga las herramientas de 'Spring Boot Tools', por ejemplo en caso de visual studio code, pude instalar la extension con el nombre antes indicado; asi mismo eclipse y netbeans soportan estas herramientas.

    - Una ves se tenga acceso  Spring Boot Tools, deberia reconocer el proyecto y podra iniciar su ejecucion.

