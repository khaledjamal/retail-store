# Retail Store Billing System

This project is a **Retail Store Billing System** developed in Java, created as part of an **on-site coding assessment** during a job interview. It was completed within one day and successfully led to a job offer. The solution demonstrates strong object-oriented design, clean code principles, and the ability to translate business rules into code efficiently under time pressure.

## 📌 Problem Statement

The task was to build a billing system that calculates the **net payable amount** for a customer after applying:

- **User-based percentage discounts**
- **Flat discounts per $100 on the bill**
- **Category-based exclusions (e.g., no discount on groceries)**

### Discount Rules

1. **Percentage-based discounts**:
   - **Employees** get a 30% discount.
   - **Affiliates** get a 10% discount.
   - **Customers** who’ve been with the store for over 2 years get a 5% discount.
   - **Groceries are excluded** from percentage-based discounts.

2. **Flat discount**:
   - For every $100 on the total bill (after applying the percentage discount), a flat $5 discount is applied.

## 🧠 Key Features

- Clean object-oriented architecture using Java
- Polymorphism and inheritance for user roles (`Employee`, `Affiliate`, `Customer`)
- Enum usage for product categorization
- Unit tests with JUnit to validate business rules
- Introduced a `ShoppingCart` abstraction to manage cart entries and decouple billing logic from item management
- Simple logging utility and date calculation helper
- Clear separation of responsibilities across classes

## 🧪 Testing

Includes multiple unit tests using **JUnit**, covering scenarios such as:

- Discounts on groceries vs. non-groceries
- Combined percentage and flat discounts
- Behavior for different user roles and durations

## 📁 Project Structure

```
src/
├── com.company.retailstore
│   ├── Bill.java
│   ├── BillTest.java
│   ├── Customer.java
│   ├── Employee.java
│   ├── Affiliate.java
│   ├── ShoppingCart.java
│   ├── ShoppingCartEntry.java
│   ├── Product.java
│   ├── ProductType.java
│   ├── User.java
│   └── util/
│       ├── DateUtil.java
│       └── Log.java
```

## 🔧 Tech Stack

- Java
- JUnit 4

## 💡 Why This Project Matters

This repository highlights my ability to:
- Quickly understand business requirements and turn them into working code
- Apply OOP concepts to build a maintainable and extensible system
- Write logic that is easy to verify and test under real-world constraints

## 🛠️ Design Decisions

Although the original problem did not require a shopping cart system, I chose to introduce a `ShoppingCart` abstraction. This decision allowed for:
- A cleaner separation between billing and cart logic
- Better extensibility for future features like item removal or cart summaries
- A more realistic domain model that mirrors common retail systems

## 🙋 About This Project

This project was developed as part of an on-site coding assessment during a multi-stage interview process. The hiring journey included:

1. An initial HR interview  
2. A technical interview at the company  
3. An on-site coding assessment (this project)  
4. A follow-up take-home coding assignment  

I successfully completed all steps and received a job offer based on my performance across both coding assessments and interviews.

## 📜 License

This code is released under the MIT License.
