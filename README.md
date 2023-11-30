# <h1 align="center">📖 Book Shop App📖 </h1>

## Introduction

**_Welcome to the Online Book Shop app!_** ⭐
* Do you want to **keep track** of the stock of books that there is in your shop?
* Do you want to use **handy** tool for that purpose?
* Are you **tired** of numerous pages of confusing documentation?
* Do you want to provide your customers with **enjoyable** way of making purchases in your book shop?
* Moreover, customers won't be limited with open hours of the shop. This service will be  **available 24/7**.

###  If you have ever faced any of the above problems, you are in the right place to solve them once and forever. 🎯

## Description of the project

### The following technologies have been used:
* **Java 17**
* **Spring boot**
* **Spring Data JPA**
* **Spring Security**
* **MySQL**
* **Swagger**
* **Lombok**
* **MapStruct**
* **Docker**
* **Liquibase**

## How to use the application?
1. Make sure you have JDK and Docker installed
2. Clone the repository from GitHub
3. Create .env file and fill in all necessary variables 
(You can find them in .env-sample)
4. Run the command mvn clean package
5. Run docker-compose up --build to build and start the Docker containers 
6. The application should be running at http://localhost:8089
7. Swagger is available for testing at http://localhost:8089/swagger-ui/index.html#/

## Database structure

![database structure](assets/database.png)

## Controllers and endpoint available ⬇

## **Authentication Controller:**

| **HTTP method** |  **Endpoint**  | **Role** | **Function**                               |
|:---------------:|:--------------:|:--------:|:-------------------------------------------|
|      POST       | /auth/register |   ALL    | Allows a new user to register              |
|      POST       |  /auth/login   |   ALL    | Authenticates a user and returns JWT token |

---

## **Book Controller:** _Managing and browsing books_

| **HTTP method** | **Endpoint** | **Role** | **Function**                                            |
|:---------------:|:------------:|:--------:|:--------------------------------------------------------|
|       GET       |    /books    |   USER   | Enables users to get all books                          |
|       GET       | /books/{id}  |   USER   | Enables users to get info about one book                |
|      POST       |    /books    |  ADMIN   | Enables admins to create a new book and save it to DB   |
|       PUT       | /books/{id}  |  ADMIN   | Enables admins to update info on an existing in DB book |
|     DELETE      | /books/{id}  |  ADMIN   | Enables admins to delete a book from DB                 |

---
## **Category Controller:** _Managing and browsing categories_

| **HTTP method** |      **Endpoint**      | **Role** | **Function**                                                |
|:---------------:|:----------------------:|:--------:|:------------------------------------------------------------|
|       GET       |      /categories       |   USER   | Enables users to get all categories                         |
|       GET       | /categories/{id}/books |   USER   | Enables users to get all books in a certain category        |
|      POST       |      /categories       |  ADMIN   | Enables admins to create a new category and save it to DB   |
|       PUT       |    /categories/{id}    |  ADMIN   | Enables admins to update info on an existing in DB category |
|     DELETE      |    /categories/{id}    |  ADMIN   | Enables admins to delete a category from DB                 |

---

## **Shopping Cart Controller:** _Managing and browsing cart items in shopping cart_

| **HTTP method** |         **Endpoint**          | **Role** | **Function**                                                                |
|:---------------:|:-----------------------------:|:--------:|:----------------------------------------------------------------------------|
|       GET       |             /cart             |   USER   | Enables users to get all cart items (books) in their shopping carts         |
|       PUT       | /cart/cart-items/{cartItemId} |   USER   | Enables users to change book quantity of a cart item in their shopping cart |
|      POST       |             /cart             |   USER   | Enables users to add book to their shopping cart                            |
|     DELETE      | /cart/cart-items/{cartItemId} |   USER   | Enables users to delete a cart item from their shopping cart                |

---


