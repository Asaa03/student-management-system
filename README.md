# Student Management System

This is a Student Management System built using Spring Boot. The application provides role-based access control for Admin, and User .

---

## 🚀 Features

### 👤 User (Student)

* Login / Registration
* View profile
* View available courses by semester
* Enroll in courses
* View enrolled courses

### 🛠️ Admin

* Login
* Dashboard: view number of users, faculty, admins
* Manage users and roles
* Add, update, delete courses

---

## 🧱 Tech Stack

* **Java 17**
* **Spring Boot 3**
* **Spring Security**
* **Thymeleaf**
* **Spring MVC**
* **MySQL** 
* **Maven** (build tool)

---

## 🛠️ Setup Instructions

```bash
git clone https://github.com/Asaa03/student-management-system.git
cd student-management-system
```

### ⚙️ Configuration

Open `src/main/resources/application.properties` and set your DB configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### ▶️ Run the Project

```bash
./mvnw spring-boot:run
```

Or run directly from your IDE (IntelliJ / Eclipse).

Then open your browser at: `http://localhost:8080`

---

[//]: # ()
[//]: # (## 📌 Future Enhancements)

[//]: # ()
[//]: # (* Attendance tracking)

[//]: # (* Marksheet generation)

[//]: # (* Course filtering)

[//]: # (* Role-based dashboards)

[//]: # (* Responsive UI using Bootstrap or Tailwind)

[//]: # (* Deployment to **Render** / **Railway**)

[//]: # ()
[//]: # (---)

