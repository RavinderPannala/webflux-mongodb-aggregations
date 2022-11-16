# WebFlux-MongoDB Aggregations

Create project with Spring boot Webflux wit MongoDB database.


=> Models 1.Employee 2.Cities 3.Sales 

Employee End points:  
1.http://localhost:8080/employee/saveEmployee
2.http://localhost:8080/employee/findById/{empId}
3.http://localhost:8080/employee/findAllEmployees
4.http://localhost:8080/employee/findAllEmployeesBySalary : Find all employees who is having salary greater than 30k

Cities End Points:

1.http://localhost:8080/cities/createCity
2.http://localhost:8080/cities/findAll
3.http://localhost:8080/cities/findByCitiesInContinent : Find all cities by continent using Aggregation classes
4.http://localhost:8080/cities/findCitiesByPopulation   : Find all cities by population by continent wise using mongodb query directly in aggregations classes

Sales End points:

1.http://localhost:8080/sales/addSale
2.http://localhost:8080/sales/findById/{saleId}
3.http://localhost:8080/sales/findAllSales 
4.http://localhost:8080/sales/searchBy/{mode}/{location}  : Searching sales with purchase mode and store location by using mongodb atlas search cloud databse
