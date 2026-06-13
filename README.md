# User Age Management (JavaFX)

Aplicación de escritorio desarrollada en **Java 21** utilizando **JavaFX** para la interfaz gráfica y **Gradle** como herramienta de automatización y gestión de dependencias. 

El proyecto implementa conceptos sólidos de Programación Orientada a Objetos (POO), haciendo uso de estructuras modernas de Java como `records` para la inmutabilidad de los modelos de datos y controladores modulares para las vistas FXML.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 21 (Uso de `record` para la estructura de datos).
* **Framework Interfaz:** JavaFX (Separación de vista y control mediante archivos FXML).
* **Gestor de Construcción:** Gradle.
* **Arquitectura:** Inspirada en el patrón MVC (Modelo-Vista-Controlador), separando de forma limpia las validaciones de negocio de la lógica de la pantalla.

## 🚀 Características del Proyecto

* **Validación Robusta:** Control de formatos mediante expresiones regulares para nombres y nicks (ej: formato `@nick`).
* **Manejo de Ficheros:** Lectura automatizada de flujos de datos desde archivos planos `.csv` (`usuarios.csv`).
* **Interfaz Dinámica:** Listados interactivos (`ListView`) que calculan y muestran en tiempo real la edad del usuario seleccionado mediante la API `java.time.Period`.

## 📦 Instalación y Ejecución

Para clonar y lanzar este proyecto localmente, necesitas tener instalado **Java JDK 21** o superior:

```bash
# Clonar el repositorio
git clone [https://github.com/otmaneDev-data/user-age-management-javafx.git](https://github.com/otmaneDev-data/user-age-management-javafx.git)

# Entrar al directorio
cd user-age-management-javafx/EdadesUsuariosOEE

# Ejecutar la aplicación usando el wrapper de Gradle
./gradlew run
