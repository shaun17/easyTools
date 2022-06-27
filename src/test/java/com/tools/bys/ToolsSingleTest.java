package com.tools.bys;

import com.tools.bys.controller.SingleController;
import com.tools.bys.vo.TxTestDO;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.HashMap;
import static org.hamcrest.Matchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
class ToolsSingleTest {

    @Autowired
    SingleController singleController;

    @Test
    void getMethod1() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);
        MockMvcResponse mockMvcResponse = givenRestAssuredSpecification.when().get("/single/getAll");
        mockMvcResponse.prettyPrint();
    }

    @Test
    void getMethod2() {
        RestAssured.get("/single/getOne?id=1", new HashMap<String,String>()).then().assertThat()
                .body("column1", equalTo("beijing"));
    }

    @Test
    void postMethod1() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given().standaloneSetup(singleController);
        givenRestAssuredSpecification.contentType("application/json")
                .body(TxTestDO.builder().column1("hangzhou").column2("小笼包").build())
                .post("/single/insert",new HashMap<>()).then().log().all();
    }
    @Test
    void mixMethod() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given().standaloneSetup(singleController);
        MockMvcResponse mockMvcResponse = givenRestAssuredSpecification.when().get("/single/getAll");
        String print = mockMvcResponse.getBody().print();
    }
}
