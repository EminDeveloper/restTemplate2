package com.jucci.resttemplate2.api;

import com.jucci.resttemplate2.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/employees";

    @Autowired
    public RestTemplate restTemplate;

    public ResponseEntity<List<EmployeeDTO>> getEmployeeList(){
        Object result = restTemplate.getForEntity(webUrl, Object.class);
        System.out.println("Result:  " + result);
        return (ResponseEntity<List<EmployeeDTO>>) result;
    }
}
