package com.jucci.resttemplate2.api;

import com.jucci.resttemplate2.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/employees";

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployeeList(){
        ResponseEntity<List> result = restTemplate.getForEntity(webUrl, List.class);
        List<EmployeeDTO> responseBody = result.getBody();

        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO){
        ResponseEntity<EmployeeDTO> result = restTemplate.postForEntity(webUrl, employeeDTO, EmployeeDTO.class);
        EmployeeDTO responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }
}
