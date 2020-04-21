package com.api.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.model.UserDevice;
import com.api.repository.UserDeviceRepository;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class QueryTest {
	
	@Autowired
    private UserDeviceRepository userDeviceRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Before
    public void setUp() {

           RestAssured.port = this.port;
    }
    
    @Test
    public void findAllDeviceReturnsJsonWith200StatusCode() throws IOException {

           saveUserDevice();

           String expetedResponse = "{\"data\":{\"findAllDevice\":[{\"userId\":\"1\",\"carrierId\":\"1\","

                        + "\"deviceId\":\"U11\",\"deviceToken\":\"T11\",\"isActive\":true,\"deviceOs\":\"IOS\","

                        + "\"deviceOsVersion\":\"OS1\"}]}}";

           GraphQLResponse findResponse = graphQLTestTemplate.perform("query/findAllDevice.graphql", null);

           String response = findResponse.getRawResponse().getBody();

           assertTrue(findResponse.isOk());

           assertEquals(expetedResponse, findResponse.getRawResponse().getBody());

}
    
    private void saveUserDevice() {

        UserDevice UserDevice = new UserDevice("1", "1", "U11", "T11", true, "IOS", "OS1");

        userDeviceRepository.saveAndFlush(UserDevice);
}


    
//    @Autowired
//    private UserDeviceRepository repo;
//    
//    public void savUserDevice(){
//    UserDevice user=new UserDevice("user101","car101","D101","T101",true,"windows","os1.1");
//    repo.saveAndFlush(user);
//    }
//
//    @Test
//    public void findAllDeviceReturnsJsonWith200StatusCode(){
//
//    	
//    	savUserDevice();
//    	
//        given().log().all()
//                .contentType("application/json")
//                .body("{\n" +
//                        "\t\"query\":\"{findAllDevice { id userId } }\"\n" +
//                        "}")
//                .post("/graphql")
//                .then()
//                
//                .body("data.findAllDevice.id", hasItems("1"))
//                .body("data.findAllDevice.userId", hasItems("user101"))
//          
//
//                .statusCode(200);
//    }
//    
    
    
 
	
    

}
