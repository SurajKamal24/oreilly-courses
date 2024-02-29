package com.oreilly.demo.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp(){
        System.out.println("Server running on port " + port);
    }

    @Test
    public void greetWithName(@Autowired TestRestTemplate template) {
        Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
        assertEquals("Hello, Dolly!", response.message());
    }

    @Test
    public void greetWithoutName(@Autowired TestRestTemplate template) {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assert response != null;
        assertEquals("Hello, World!", response.message());
    }

    void postGreet_withNameInURL() {
        Greeting greeting = new Greeting("Dolly");
        ResponseEntity<Greeting> entity = template.postForEntity("/rest", greeting, Greeting.class);
        assertEquals(HttpStatus.CREATED, entity.getStatusCode());
        Greeting response = entity.getBody();
        assert response != null;
        assertEquals("Hello, World!", response.message());
    }


}
