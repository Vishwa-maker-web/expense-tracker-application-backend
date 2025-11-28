# Family Expense Tracker – Backend

A simple Spring Boot backend for tracking daily expenses with CRUD APIs, DTO, Validation, and MySQL.

---

## 🚀 Features
- Add new expense
- Update / delete expense
- Fetch all expenses sorted by date (latest first)
- Get totals:
  - Today total
  - Weekly total
  - Monthly total
  - Category-based total
- Dashboard summary API
- DTO + Input validation

---

## 🛠 Tech Stack
| Tool | Purpose |
|------|---------|
| Java 17 | Backend Language |
| Spring Boot | REST API |
| Spring Data JPA | Database Operations |
| MySQL | Database |
| Hibernate | ORM |


---

## 📂 Project Structure
src/main/java/com/vishwag/expence/tracker/application
├── controller
├── service
├── repository
├── entity
└── dto

---

## 🔗 API Endpoints (Examples)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/expenses` | Add new expense |
| GET | `/api/expenses` | Get all expenses |
| DELETE | `/api/expenses/{id}` | Delete expense |
| GET | `/api/expenses/latest` | Latest sorted expenses |
| GET | `/api/expenses/summary/month?month=11&year=2025` | Monthly summary |

---

## 📸 Screenshots

View all screenshots here 👇  

https://github.com/Vishwa-maker-web/expense-tracker-application-backend/tree/master/Screenshot

---

## 🧩 How to Run Locally
git clone https://github.com/Vishwa-maker-web/expense-tracker-application-backend.git

cd expense-tracker-application-backend

### 1️⃣ Create MySQL Database
```sql
CREATE DATABASE expense_db;
2️⃣ Update DB Credentials in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
3️⃣ Run Spring Boot App
mvn spring-boot:run
Server will start at:
👉 http://localhost:8080/

👤 Author
 Vishwa G
 Developer 

