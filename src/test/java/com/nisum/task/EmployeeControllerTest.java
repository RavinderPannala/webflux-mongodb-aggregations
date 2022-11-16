package com.nisum.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.nisum.task.controller.EmployeeController;
import com.nisum.task.entity.Employee;
import com.nisum.task.service.EmployeeService;
import static org.mockito.Mockito.times;

import static org.hamcrest.CoreMatchers.equalTo;

import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@WebFluxTest(controllers = EmployeeController.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest 
{
 // @MockBean
  //EmployeeRepository repository;
  
  @MockBean
  private EmployeeService employeeService;
 
  @Autowired
  private WebTestClient webClient;
 
  @Test
 public  void testCreateEmployee() {
    Employee employee = new Employee();
    employee.setId(4L);
    employee.setFirstName("Suresh");
    employee.setLastName("L");
    employee.setAge("40");
    employee.setSalary(55000d);
    
    Mockito.when(employeeService.saveEmployee(employee)).thenReturn(Mono.just(employee));
 
    webClient.post()
      .uri("/employee/saveEmployee")
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromObject(employee))
      .exchange()
      .expectStatus().isOk();
 
    Mockito.verify(employeeService,times(1)).saveEmployee(employee);
  }
   

   
  @Test
   public void testGetEmployeeById() 
  {
        webClient.get().uri("/employee/findById/{empId}", 1)
          .exchange()
          .expectStatus().isOk()
          .expectBody(Employee.class)
          .value(emp -> emp.getId(),equalTo(1l))
          .value(emp -> emp.getFirstName(), equalTo("Sridhar"))
          .value(emp -> emp.getLastName(), equalTo("P"))
          .value(emp -> emp.getAge(), equalTo("28"))
          .value(emp -> emp.getSalary(), equalTo("10"));
          
         
        //Mockito.verify(employeeService,times(1)).findById(2L);
    }
 

}