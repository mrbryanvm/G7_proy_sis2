# Sistema Gestor de Biblioteca 📚

### Grupo N°7

#### **Integrantes**  
1. **Conde Rodriguez Raul Cesar** - *TEAM*  
2. **Corrales Delgadillo Javier Gustavo** - *QA*  
3. **Vasquez Maldonado Bryan** - *SCRUM MASTER*  
4. **Vera Vera Fernando** - *QA*  
5. **Zeballos Cepeda Jhuly Kely** - *QA*  

---

## **Descripción del Modelo de Negocio**

El modelo de negocio se centra en la **gestión eficiente de los servicios de una biblioteca universitaria (UMSS)**. Este sistema automatiza las operaciones principales, como préstamos de libros, gestión de inventarios, usuarios y generación de reportes. Su propósito es garantizar un acceso rápido y efectivo a la información relevante para estudiantes y personal administrativo.  

---

### **Objetivo Principal del Sistema**
Desarrollar una aplicación de escritorio para la biblioteca universitaria que permita:  
- 📖 Gestionar libros disponibles y en préstamo.  
- 👥 Registrar usuarios (estudiantes, profesores, personal administrativo, etc.).  
- 📚 Controlar el inventario de libros (altas, bajas, actualizaciones).  
- 📊 Generar reportes administrativos.  
- ✅ Automatizar los procesos de reserva y devolución.  

---

### **Procesos Clave**

#### **1. Registro de Usuarios**  
- Los usuarios se registran con su nombre y correo electrónico.  
- Una vez validado el correo, crean su contraseña y quedan habilitados para préstamos.  

#### **2. Préstamo de Libros**  
- El administrador selecciona al usuario registrado.  
- Se completa un formulario con los datos del libro y el usuario.  
- Se especifica el tipo de préstamo (sala o externo).  
- El estado del libro en el inventario se actualiza automáticamente.  

#### **3. Devolución de Libros**  
- El administrador verifica el estado físico del libro y la fecha de devolución.  
- En devoluciones puntuales, el sistema actualiza el inventario.  
- Retrasos generan incidencias en el historial del usuario.  
- Más de tres incidencias añaden al usuario a la **lista roja**.  

#### **4. Gestión de Recursos Académicos**  
- El personal registra nuevos materiales académicos o actualiza cantidades existentes.  
- Validación de datos y ISBN para garantizar registros precisos.  
- Confirmación del registro con generación de código de barras o QR.  

#### **5. Generación de Reportes**  
- Reportes como libros más consultados, usuarios frecuentes o estado del inventario.  
- Representación en gráficos y tablas para facilitar análisis.  

#### **6. Manejo de la Lista Roja**  
- Usuarios en la lista roja tienen restricciones para futuros préstamos.  

---

### **Información Gestionada**
1. **Catálogo de libros**  
   - Título, autor, editorial, año de publicación, ISBN, estado.  
2. **Usuarios**  
   - Matrícula o ID, nombre completo, carrera/departamento, correo electrónico, historial de préstamos.  
3. **Préstamos y devoluciones**  
   - ID del libro, ID del usuario, fechas de préstamo y devolución, multas por retrasos.  
4. **Reportes administrativos**  
   - Libros más prestados, usuarios con retrasos frecuentes, estado del inventario.  
5. **Reservas**  
   - Reserva anticipada de libros para usuarios registrados.  

---

### **Estadísticas y Reportes**
- **Estadísticas de Préstamos**: Comparación entre préstamos en sala y externos, históricos diarios y mensuales.  
- **Historial de Estudiantes**: Listados de estudiantes frecuentes y sus préstamos históricos.  
- **Control de Incidencias**: Registro de estudiantes en la lista roja y cantidad de incidencias.  

---

### **Actores Principales**

#### **1. Administrador del Sistema**  
- Acceso total a la aplicación.  
- Administra el inventario de libros.  
- Supervisa reportes administrativos.  
- Gestiona registros de usuarios.  

#### **2. Bibliotecario/a**  
- Registra préstamos y devoluciones.  
- Gestiona reservas.  
- Consulta disponibilidad en el inventario.  

#### **3. Estudiantes y Profesores (Usuarios)**  
- Consultan el catálogo de libros.  
- Reservan libros en línea.  
- Verifican su historial de préstamos.  
- Reciben notificaciones sobre devoluciones o retrasos.  

#### **4. Departamento Administrativo**  
- Recibe reportes sobre el uso del sistema (libros más prestados, usuarios con retrasos frecuentes, etc.).  

---

🎯 **Este sistema busca optimizar la gestión de recursos y mejorar la experiencia de todos los usuarios de la biblioteca universitaria.**
