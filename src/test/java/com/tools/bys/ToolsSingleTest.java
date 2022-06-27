package com.tools.bys;

import com.alibaba.fastjson.JSON;
import com.tools.bys.controller.SingleController;
import com.tools.bys.vo.TxTestDO;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.response.ValidatableMockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestAsyncConfigurer;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.module.spring.commons.config.AsyncConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);

        givenRestAssuredSpecification.get("/single/getOne?id=1").then().log().all().assertThat()
                .body("column1", equalTo("beijing"));
    }

    @Test
    void getMethod3() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);

        givenRestAssuredSpecification.param("id",1).get("/single/getOne")
                .then().log().all().assertThat()
                .body("column1", equalTo("beijing"));
    }
    @Test
    void getMethod4() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);

        givenRestAssuredSpecification.body(1).contentType("application/json").when().async()
                .post("/single/asy").then().log().all();
    }

    @Test
    void postMethod1() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given().standaloneSetup(singleController);
        givenRestAssuredSpecification.contentType("application/json")
                .body(TxTestDO.builder().column1("hangzhou").column2("小笼包").build())
                .post("/single/insert").then().log().all();
    }
    @Test
    void mixMethod() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given().standaloneSetup(singleController);
        MockMvcResponse mockMvcResponse = givenRestAssuredSpecification.when().get("/single/getAll");
        String print = mockMvcResponse.getBody().print();
    }
}
