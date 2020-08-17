# Springboot and angular10 Demo App

## Springboot

Copy springboot config file before running program.
```
cp newboot/src/main/resources/application.properties.example newboot/src/main/resources/application.properties
```
### Api Lists
- /authenticate [METHOD: POST] (Login api)
- /orders [METHOD: GET] (List of all user orders)
- /orders/markPaid/{id} [METHOD: GET] (Marks order as paid)
- /orders/placeOrder [METHOD: POST] (Places order)

## Angular
This demo app contains two roles.
- Store owner
    - Can list user orders
    - Can mark them as paid
- Normal user
    - Can place order

## Credential
- admin user
    - username: dinesh
    - password: admin
- normal user
    - username: test or sample
    - password: admin

**Note: _Admin role is hardcoded to username dinesh._**