# ERS
Expense Reimbursement System full stack web app

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

- Java - version 1.8
- Javalin - version 1.2.17
- PostgrSQL - version 13.2
- HTML - version HTML5
- CSS - version CSS3
- JavaScript - ES6
- JDBC
- AWS RDS

## Features

- A user (employee or manager) can register and login to an account.
- Employees can view all of their reimbursments and submit a reimbursment.
- A manager can view all of employees reimbursement and approve or decline them.

### To-do list:

- Sort reimbursement by status: pending, approve or decline.

## Getting Started

- `git clone`
- Download intellij community edition.
- Run MainDriver.java
- In a browser nagivate to localhost:9001

## **Usage**

- When the server is up and running, open your browser of choice and navigate to the `index.html`.
- The landing page will be the login page, if you an account is not created, the navigation bar provides a registration page.
- After registration, the app will redirect to the login page.
- If the credentials in the login page are correct, the app will redirect to the home page where a user can create a reimbursement.
- When creating a reimbursment: add the ammount spent to be reimburst, a type and short description.
- After a succesfull submission of a reimbursement, the app will redirect to the home page where it will be populated with created reimbursements.
- In the manager side of the app, they can follow the same step as an employee when registrating and login.
- A manager can create see all of the employee reimbursments.
- Afterward they can approve or decline reimbursements.

## **License**

This project uses the following license: 