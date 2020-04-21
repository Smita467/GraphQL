//package com.api.resolver;
//
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import io.restassured.RestAssured;
//import io.restassured.parsing.Parser;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
//public class MutationTest {
//	
//	@Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @LocalServerPort
//    private int port;
//
//    private static final String PATH = "/graphql";
//    private static final String APP_JSON = "application/json";
//
//    @Before
//    public void setUp(){
//        RestAssured.port = this.port;
//        RestAssured.defaultParser = Parser.JSON;
//    }
//    
//    @Test
//    public void insertNewLocationReturn_IdOfNewObject(){
//       // Integer noBefore = getNumberOfLocation();
//
//        given().log().all()
//                .contentType(APP_JSON)
//                .body("{\n" +
//                        "   \"query\": \"mutation newLocation($userId: String!, $carrierId: String!, $deviceId: String!, $deviceToken: String!, $isActive: Boolean, $deviceOs: String!, \r\n" + 
//                        "    $deviceOsVersion: String!)) { newLocation($userId: String!, $carrierId: String!, $deviceId: String!, $deviceToken: String!, $isActive: Boolean, $deviceOs: String!, \r\n" + 
//                        "    $deviceOsVersion: String!)){ id } }\",\n" +
//                        "\t\"variables\":\"{ \\\"userId\\\" : \\\"user102\\\", \\\"state\\\": \\\"TX\\\", \\\"zipCode\\\": \\\"76017\\\" }\"\n" +
//                        "}")
//                .post(PATH)
//                .then()
//                .body("data.newLocation.id", greaterThan("0"))
//                .statusCode(200);
//
//        Integer noAfter = getNumberOfLocation();
//
//        assertThat(noAfter, is(noBefore + 1));
//    }
//
//
//}
