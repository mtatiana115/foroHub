# foroHub
# 🚀 ForoHub API

¡Bienvenido al repositorio de la API REST de ForoHub!

Este proyecto es una API que gestiona tópicos de un foro, permitiendo a los usuarios crear, listar, ver en detalle, actualizar y eliminar tópicos. La API está protegida con Spring Security y autenticación JWT para garantizar que solo los usuarios autorizados puedan interactuar con los recursos.

## 🛠️ Tecnologías Utilizadas

* **Java 17**: El lenguaje principal de desarrollo.
* **Spring Boot 3**: Framework para el desarrollo de la API.
* **Spring Security**: Módulo para manejar la seguridad y autenticación.
* **JWT (Java JWT)**: Para la generación y validación de tokens.
* **MySQL**: Base de datos relacional para la persistencia de datos.
* **Maven**: Administrador de dependencias.

## ⚙️ Configuración del Entorno

### Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu máquina:

* **JDK 17** o superior.
* **Maven 3.6** o superior.
* **MySQL 8** o una base de datos compatible.

### Configuración de la Base de Datos

1.  Crea una base de datos llamada `forohub` en tu servidor MySQL.
2.  Abre el archivo `src/main/resources/application.properties` y configura las credenciales de tu base de datos:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forohub
    spring.datasource.username=tu_usuario_mysql
    spring.datasource.password=tu_contraseña_mysql
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  Configura la clave secreta para el token JWT:

    ```properties
    api.security.secret=tu-super-secreto-seguro-y-largo
    ```

## 🚀 Despliegue de la Aplicación

Sigue estos pasos para levantar la aplicación en tu entorno local.

1.  **Clonar el repositorio:**

    ```bash
    git clone [https://github.com/tu-usuario/nombre-del-repositorio.git](https://github.com/tu-usuario/nombre-del-repositorio.git)
    cd nombre-del-repositorio
    ```

2.  **Compilar el proyecto:**

    Usa Maven para compilar la aplicación. Esto descargará todas las dependencias y empaquetará el proyecto.

    ```bash
    mvn clean install
    ```

3.  **Ejecutar la aplicación:**

    Ejecuta el archivo JAR que se encuentra en la carpeta `target`.

    ```bash
    java -jar target/forohub-0.0.1-SNAPSHOT.jar
    ```

    La API se iniciará en `http://localhost:8080`.

## 🔒 Autenticación y Endpoints

### 1. Obtener un Token JWT

Para interactuar con la API, primero debes autenticarte.

* **URL:** `POST http://localhost:8080/login`
* **Cuerpo de la solicitud (JSON):**

    ```json
    {
      "login": "tu_usuario",
      "clave": "tu_contraseña"
    }
    ```

    El servidor te devolverá un token JWT.

### 2. Acceder a los Endpoints Protegidos

Una vez que tengas el token, debes incluirlo en el encabezado `Authorization` de cada solicitud a los demás endpoints:

* **Encabezado:** `Authorization: Bearer <tu_token_jwt>`

Aquí tienes una lista de los endpoints principales:

| HTTP Method | URL                 | Descripción                                 |
| :---------- | :------------------ | :------------------------------------------ |
| **POST** | `/topicos`          | Crea un nuevo tópico.                       |
| **GET** | `/topicos`          | Lista todos los tópicos con paginación.      |
| **GET** | `/topicos/{id}`     | Muestra los detalles de un tópico específico. |
| **PUT** | `/topicos/{id}`     | Actualiza un tópico existente.              |
| **DELETE** | `/topicos/{id}`     | Elimina (lógicamente) un tópico.            |

---