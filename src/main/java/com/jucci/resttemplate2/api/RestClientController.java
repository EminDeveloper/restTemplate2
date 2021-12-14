package com.jucci.resttemplate2.api;

import com.jucci.resttemplate2.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    private static final String webUrl = "http://localhost:8080/";

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployeeList(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("X-COM-LOCATION", "Azerbaijan");
        HttpEntity<EmployeeDTO> requestEntity = new HttpEntity<>(null, headers);
        /* send get */
        ResponseEntity<List> result = restTemplate.exchange(webUrl + "employees", HttpMethod.GET, requestEntity, List.class);
        List<EmployeeDTO> responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }



    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO){
        /* send post  */
        ResponseEntity<EmployeeDTO> result = restTemplate.postForEntity(webUrl + "employee", employeeDTO, EmployeeDTO.class);
        EmployeeDTO responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }
}
