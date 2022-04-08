package com.example.javaapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class JavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}

}

@RestController
class JavaApi {

    @GetMapping("/hello")
    String index() {
        return "Hello world from Java";
    }

    @GetMapping("/customHeader")
	ResponseEntity<Object> customHeader() {
    		
		HttpHeaders headers = new HttpHeaders();
    		headers.add("Custom-Header", "foo");
		headers.set("Connection", "close");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Custom header set");

    	return new ResponseEntity<Object>(
      		map, headers, HttpStatus.OK);
    }

}
