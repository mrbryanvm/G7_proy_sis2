
---

## **📌 Pruebas Unitarias en el Proyecto 📚**
Este repositorio contiene la implementación y las pruebas unitarias de tres clases fundamentales dentro del sistema de gestión de bibliotecas. Las pruebas han sido desarrolladas utilizando **JUnit 5** para garantizar la calidad del código y el correcto funcionamiento de cada clase.  

---

## **📝 Clases Probadas**
### **1️⃣ Libro**
📖 **Descripción:**  
La clase `Libro` representa un libro en la biblioteca, con atributos como nombre, autor, año de publicación, ISBN, cantidad disponible y estado de disponibilidad.  

🔍 **Mejoras Implementadas:**  
✅ Validación del nombre, autor y editorial (no pueden estar vacíos).  
✅ Restricción del año (no puede ser mayor al año actual).  
✅ Validación del ISBN (debe contener 13 dígitos).  
✅ Control automático de disponibilidad basado en la cantidad de libros.  
✅ Métodos para prestar y devolver libros.  

🧪 **Pruebas Realizadas:**  
✔️ Verificación del constructor y los valores iniciales.  
✔️ Prueba de getters y setters.  
✔️ Validación de ISBN incorrecto.  
✔️ Control de disponibilidad al prestar y devolver libros.  

---

### **2️⃣ Administrador**
👤 **Descripción:**  
La clase `Administrador` representa un usuario con privilegios de gestión en la biblioteca, con atributos como nombre, apellido, CI, correo, teléfono y contraseña.  

🔍 **Mejoras Implementadas:**  
✅ Validación del nombre y apellido (no pueden estar vacíos).  
✅ Restricción del CI (debe ser positivo).  
✅ Validación del correo (debe seguir un formato válido).  
✅ Restricción del teléfono (debe tener 8 dígitos).  
✅ Reglas de seguridad en la contraseña (mínimo 8 caracteres, una mayúscula y un número).  

🧪 **Pruebas Realizadas:**  
✔️ Verificación del constructor y valores iniciales.  
✔️ Prueba de setters y getters.  
✔️ Validación de correo incorrecto.  
✔️ Restricción de longitud en el teléfono.  
✔️ Reglas de seguridad en la contraseña.  

---

### **3️⃣ Sistema de Préstamos (Libro)**
🔄 **Descripción:**  
Las pruebas sobre la clase `Libro` incluyeron la gestión del sistema de préstamos y devoluciones, asegurando que los libros puedan prestarse solo si están disponibles.  

🔍 **Mejoras Implementadas:**  
✅ Restricción en `prestarLibro()` para evitar préstamos sin stock.  
✅ Control automático de la cantidad de libros.  
✅ Manejo de excepciones cuando se intenta prestar un libro sin disponibilidad.  

🧪 **Pruebas Realizadas:**  
✔️ Comprobación del método `prestarLibro()`.  
✔️ Validación de cambios en la cantidad de libros.  
✔️ Comprobación del estado de disponibilidad después de préstamos y devoluciones.  

---

## **🚀 Tecnologías Utilizadas**
- **Java 17+**
- **JUnit 5**
- **Visual Studio Code**
- **Maven (Opcional, para gestión de dependencias)**

## **📦 Instalación y Ejecución**
Si deseas ejecutar las pruebas en tu entorno local:  

1️⃣ **Clonar el repositorio**  
```sh
git clone https://github.com/tu_usuario/tu_repositorio.git
cd TestSegundoSprint
```

2️⃣ **Ejecutar las pruebas con Maven** (si usas Maven)  
```sh
mvn test
```

3️⃣ **Ejecutar las pruebas en Visual Studio Code**  
- Abre el proyecto en VS Code.  
- Navega hasta los archivos de prueba (`LibroTest.java`, `AdministradorTest.java`).  
- Haz clic en **"Run Test"** sobre cada método o ejecuta todos los tests desde la interfaz de JUnit.  

---

## **🎯 Conclusión**
Estas pruebas unitarias permiten asegurar que el sistema de gestión de la biblioteca funcione correctamente y cumpla con las validaciones esperadas. Gracias a **JUnit 5**, podemos detectar errores antes de la implementación final y mejorar la calidad del código.  

💡 **Siguientes pasos:**  
- Agregar más validaciones a `Administrador` (ejemplo: permisos de acceso).  
- Implementar persistencia de datos en una base de datos.  
- Extender el sistema con más funcionalidades como reportes de préstamos y usuarios.  

---
