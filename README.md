# WebFlux-MongoDB Aggregations

Create project with Spring boot Webflux wit MongoDB database.


=> Models 1.Employee 2.Cities 3.Sales 

Employee End points:  
1.http://localhost:8080/employee/saveEmployee
1.http://localhost:8080/employee/findById/{empId}
1.http://localhost:8080/employee/findAllEmployees
1.http://localhost:8080/employee/findAllEmployeesBySalary : Find all employees who is having salary greater than 30k

Cities End Points:

1.http://localhost:8080/cities/createCity
1.http://localhost:8080/cities/findAll
1.http://localhost:8080/cities/findByCitiesInContinent : Find all cities by continent using Aggregation classes
1.http://localhost:8080/cities/findCitiesByPopulation   : Find all cities by population by continent wise using mongodb query directly in aggregations classes