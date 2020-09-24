# employeeDetails

This employee rest api has all the http methods and endpoints to perform add, get, update and delete employees.

All the employees details can be stored in MYSQL database and retrieved accordingly using endpoints.

Every endpoint validated by JWT token:

first need to create a token by using a end point http://localhost:8081/token and need to provide username, id and role. 
once you the get the token, it has to be passed for every endpoint to access those endpoints.
Eexceptions handled for every endpoint using jersey dependencies.
and also bean validations used for every fields.

for swagger documention refer http://localhost:8081/v2/api-docs


