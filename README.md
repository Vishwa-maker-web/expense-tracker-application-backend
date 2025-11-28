# Family Expense Tracker - Backend

This is a Spring Boot backend application for tracking family expenses.  
It includes CRUD operations, DTO, Validation, and MySQL database integration.

---

## 🚀 Features

- Add new expenses
- View all expenses in sorted order (latest first)
- Update existing expenses
- Delete expenses by ID
- Calculate expense totals:
  - Today Total
  - Weekly Total
  - Monthly Total
  - Total Spent
- Filter by category

---

## 🛠 Tech Stack

| Technology | Usage |
|-----------|------|
| Java 17 | Backend Language |
| Spring Boot | REST API Development |
| Spring Data JPA | Database ORM |
| MySQL | Database |
| Maven | Build Tool |

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/expenses | Get all expenses |
| GET | /api/expenses/{id} | Get single expense by ID |
| POST | /api/expenses | Add new expense |
| PUT | /api/expenses/{id} | Update expense |
| DELETE | /api/expenses/{id} | Delete expense |
| GET | /api/expenses/summary/today | Today's total spent |
| GET | /api/expenses/summary/week | Weekly total spent |
| GET | /api/expenses/summary/month?month=&year= | Monthly total spent |
| GET | /api/expenses/category/{category} | Category-wise total |
| GET | /api/dashboard | Dashboard summary (Today + Week + Month + Total)

---

## 🗄 Database Configuration (application.properties)
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---

## ▶️ How to Run Project

1. Clone the repository:
git clone https://github.com/Vishwa-maker-web/expense-tracker-application-backend.git
2. Open the project in IntelliJ IDEA
3. Create a MySQL database:
2. Open the project in IntelliJ IDEA
3. Create a MySQL database:
4. 4. Update MySQL username & password in application.properties
5. Run the Spring Boot project

---

## 📷 Screenshots


---

## 👨‍💻 Developer

**Vishwa G**  
Backend Developer (Java + Spring Boot)

---

📌 You can add frontend later if needed — backend is fully ready! 💪🔥  

