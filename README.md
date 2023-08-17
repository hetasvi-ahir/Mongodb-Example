# Mongodb-Example
Here is a sample project for MongoDB + Spring boot 3 

# Tech Used

![Springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot) ![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white) 

# Endpoints to Access 
```
  Insert item in database
  [POST] localhost:8080/api/v1/items
  JSON body to insert item { "name": "Mango", "quantity":3 "category":"Grocery" }
```
```
  Get items by name
  [GET] localhost:8080/api/v1/itembyname
  JSON body to insert item { "name": "Mango"}
```
```
  Get List of Items
  [GET] localhost:8080/api/v1/items
```
```
  Delete Item by ID
  [DELETE] localhost:8080/api/v1/items/1
```
```
  Update Item by id
  [PUT] localhost:8080/api/v1/items/1 
```
