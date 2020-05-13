package com.example.springboot;

import com.example.springboot.vo.EmployeeListVO;
import com.example.springboot.vo.EmployeeVO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;



@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }



    @RequestMapping(path="/{name}/{age}")
    public String getMessage(@PathVariable("name") String name,
                             @PathVariable("age") String age) {

        String msg = String.format("%s is %s years old", name, age);

        return msg;
    }


    @RequestMapping(path="/coal-mine")
    public String getMessage() {

        String msg = "TWEET" ;

        return msg;
    }

    @RequestMapping(value = "/employees")
    public EmployeeListVO getAllEmployeesJSON()
    {
        EmployeeListVO employees = new EmployeeListVO();

        EmployeeVO empOne = new EmployeeVO("Waseem","Kunji","howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO("Amit","Singhal","asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO("Anoop","unnik","anoop@gmail.com");


        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);

        return employees;
    }

    @RequestMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            EmployeeVO empOne = new EmployeeVO("Waseem","Kunji","howtodoinjava@gmail.com");
            return new ResponseEntity<EmployeeVO>(empOne, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }





    @RequestMapping(value = "/employeexml",
    		produces=MediaType.APPLICATION_XML_VALUE)
    public EmployeeListVO getAllEmployeesXML()
    {
        EmployeeListVO employees = new EmployeeListVO();

        EmployeeVO empOne = new EmployeeVO("Waseem","Kunji","howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO("Amit","Singhal","asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO("Anoop","unnik","anoop@gmail.com");


        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);

        return employees;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = { "application/xml", "text/xml" }, consumes = MediaType.ALL_VALUE )
    @ResponseBody
    public EmployeeListVO search() {
    	 EmployeeListVO employees = new EmployeeListVO();

         EmployeeVO empOne = new EmployeeVO("Waseem","Kunji","howtodoinjava@gmail.com");
         EmployeeVO empTwo = new EmployeeVO( "Amit","Singhal","asinghal@yahoo.com");
         EmployeeVO empThree = new EmployeeVO( "Anoop","unnik","anoop@gmail.com");


         employees.getEmployees().add(empOne);
         employees.getEmployees().add(empTwo);
         employees.getEmployees().add(empThree);

         return employees;
    }
    
    
    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody EmployeeVO student) {
      //Student savedStudent = studentRepository.save(student);
    	EmployeeVO empOne = new EmployeeVO("Waseem","Kunji","howtodoinjava@gmail.com");

      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
          .buildAndExpand(empOne.getId()).toUri();

      return ResponseEntity.created(location).build();

    }





}
