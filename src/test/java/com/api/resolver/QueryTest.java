package com.api.resolver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.model.UserDevice;
import com.api.repository.UserDeviceRepository;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class QueryTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
    private int port;

    @Before
    public void setUp(){
        RestAssured.port = this.port;
    }
    
    public void findAllDeviceReturnsJsonWith200StatusCode(){

        given().log().all()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"query\":\"{findAllDevice { id userId } }\"\n" +
                        "}")
                .post("/graphql")
                .then()
                //.log()
                .body("data.findAllDevice.id", hasItems("1", "2", "3"))
                .body("data.findAllDevice.userId", hasItems("user101", "user102", "user103"))
                .statusCode(200);
    }
	
//	@MockBean
//	private UserDeviceRepository repo;
//	
//	
//	@Test
//	public void findAllDeviceTest()
//	{
//		when(repo.findAll()).thenReturn((Iterable<UserDevice>) Stream.of(new UserDevice("user101","car101","D101","T101",true,"windows","os1.1")));
//	    assertEquals(1, (repo.findAll()));
//	}
    
    
    

}
