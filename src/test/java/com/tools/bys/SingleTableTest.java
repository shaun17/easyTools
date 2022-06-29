package com.tools.bys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tools.bys.biz.generator.domain.TxTest;
import com.tools.bys.controller.SingleController;
import com.tools.bys.vo.TxTestDO;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.hamcrest.Matchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
class SingleTableTest {

    @Autowired
    SingleController singleController;

    @Test
    void testGetAll() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);
        givenRestAssuredSpecification.when().get("/single/getAll").then().log().all().assertThat();

    }

    @Test
    void testGetOne() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);

        givenRestAssuredSpecification.get("/single/getOne?id=1").then().log().all().assertThat()
                .body("column1", equalTo("beijing"));
    }

    @Test
    void testGetOne2() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);

        givenRestAssuredSpecification.param("id",1).get("/single/getOne")
                .then().log().all().assertThat()
                .body("column1", equalTo("beijing"));
    }
    @Test
    void testAsy() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);

        givenRestAssuredSpecification.body(1).contentType("application/json").when().async()
                .post("/single/asy").then().log().all();
    }

    @Test
    void testPostInsert() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given().standaloneSetup(singleController);
        givenRestAssuredSpecification.contentType("application/json")
                .body(TxTestDO.builder().column1("hangzhou").column2("小笼包").build())
                .post("/single/insert").then().log().all();
    }

    @Test
    void testMix() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given().standaloneSetup(singleController);
        String id = givenRestAssuredSpecification.param("id", 12).get("/single/getOne").andReturn().asString();
        TxTestDO result = JSONObject.parseObject(id, TxTestDO.class);
        result.setColumn2("猪油拌粉");
        TxTestDO build = TxTestDO.builder().id(result.getId()).column1(result.getColumn1()).column2(result.getColumn2()).build();
        givenRestAssuredSpecification.contentType("application/json");
        givenRestAssuredSpecification.body(build).post("/single/update").then().log().all().assertThat();

    }
}
