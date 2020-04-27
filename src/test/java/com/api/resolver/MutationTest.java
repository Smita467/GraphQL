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
public class MutationTest {
	
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
    public void insertNewUserDevice() throws IOException
    {
    	
    	
    	 String expetedResponse = "{\"data\":{\"newDevice\":{\"userId\":\"1\",\"carrierId\":\"1\",\"deviceId\":\"U11\",\"deviceToken\":\"T11\",\"isActive\":true,\"deviceOs\":\"IOS\",\"deviceOsVersion\":\"OS1\"}}}";
    	 
    	 GraphQLResponse findResponse = graphQLTestTemplate.perform("query/saveUserDevice.graphql", null);

         String response = findResponse.getRawResponse().getBody();

         assertTrue(findResponse.isOk());

         assertEquals(expetedResponse, findResponse.getRawResponse().getBody());
       }
    
    

    @Test
	public void updateUserDeviceTest() throws IOException 
	{
    	saveUserDevice1();
		
   	 String expetedResponse1="{\"data\":{\"updateUserDevice\":{\"userId\":\"2\",\"carrierId\":\"1\",\"deviceId\":\"U11\",\"deviceToken\":\"T11\",\"isActive\":true,\"deviceOs\":\"IOS\",\"deviceOsVersion\":\"OS1\"}}}";
		GraphQLResponse findResponse = graphQLTestTemplate.perform("query/updateUserDevice.graphql", null);

	    String response = findResponse.getRawResponse().getBody();

        assertTrue(findResponse.isOk());
        assertEquals(expetedResponse1, findResponse.getRawResponse().getBody());

	}
    
    
    @Test
	public void deleteUserDeviceTest() throws IOException 
	{
    	saveUserDevice1();
		
    	
		GraphQLResponse findResponse = graphQLTestTemplate.perform("query/deleteUserDevice.graphql", null);

	    String response = findResponse.getRawResponse().getBody();

        assertTrue(findResponse.isOk());
       

	}
    
    private void saveUserDevice1() {
    	
   	   UserDevice UserDevice = new UserDevice("1", "1", "U11", "T11", true, "IOS", "OS1");
  
   	   userDeviceRepository.saveAndFlush(UserDevice);
   }
}




