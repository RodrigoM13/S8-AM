# 📚 Aplicación de Registro de Alumnos y Profesores

## 🧠 Características Principales

### 🔐 Inicio de Sesión
- Selección de rol: `Profesor` o `Alumno`.
- Validación de acceso:
  - **Profesores**: acceden usando su **DNI** como usuario y contraseña.
  - **Alumnos**: acceden usando su **código de alumno** como usuario y su **DNI** como contraseña.
- Se permite el acceso a usuarios predefinidos y a los **registrados durante el uso de la aplicación** (se mantienen en memoria durante la sesión).

### 🧭 Navegación Principal (Drawer)
Dependiendo del rol, se muestran distintos menús:

#### 👨‍🏫 Para Profesores:
- **Asistencia**: formulario de registro de profesores.
- **Lista de registros**: muestra todos los profesores y alumnos registrados.
- **Web**: abre una página web integrada.
- **Cerrar sesión**.

#### 👨‍🎓 Para Alumnos:
- **Asistencia**: formulario de registro de alumnos.
- **Web**: abre una página web integrada.
- **Cerrar sesión**.

### 📝 Registro
- **Formulario dinámico** según el rol:
  - Alumnos registran: `Código`, `Nombres`, `Apellidos`, `DNI`, `Teléfono`, `Correo`.
  - Profesores registran: `Nombres`, `Apellidos`, `DNI`, `Teléfono`, `Correo`.
- Los datos se guardan en **listas en memoria** durante la sesión actual.

### 📋 Lista de Registros
- Vista con separadores: muestra por separado:
  - 👨‍🎓 Alumnos (con su código, nombres, correo y teléfono).
  - 👨‍🏫 Profesores (con sus nombres, correo y teléfono).

### 🌐 Web
- Carga un sitio web dentro de la aplicación usando `WebView`.

### 🚪 Cerrar sesión
- Retorna al `LoginActivity`.

## ✅ Usuarios de prueba

### Profesores:
- Usuario: `12345678`, Contraseña: `123456`
- Usuario: `87654321`, Contraseña: `654321`

### Alumnos:
- Usuario: `202114043`, Contraseña: `12345678`
- Usuario: `202114032`, Contraseña: `87654321`

A continuación, se adjuntarán imagenes del funcionamiento del aplicativo

### 🔐 Login Alumno
![Login](screenshots/Login_Alumno.png)

### 🔐 Login Profesor
![Login](screenshots/Login_Profesor.png)

### 🔐 Main
![Login](screenshots/Main.png)

### 🔐 Menu Alumno
![Login](screenshots/Menu_Alumno.png)

### 🔐 Menu Profesor
![Login](screenshots/Menu_Profesor.png)

### 🔐 Sitio Web
![Login](screenshots/Sitio_Web.png)

### 🔐 Asistencia Alumno
![Login](screenshots/Asistencia_Alumno.png)

### 🔐 Asistencia Profesor
![Login](screenshots/Asistencia_Profesor.png)

### 🔐 Lista de Registro (Alumno)
![Login](screenshots/Lista_Registro_Solo_Alumno.png)

### 🔐 Lista de Registro Completo
![Login](screenshots/Lista_Registro_Completo.png)
