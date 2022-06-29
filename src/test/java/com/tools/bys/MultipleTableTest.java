package com.tools.bys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tools.bys.controller.MultipleController;
import com.tools.bys.vo.MultipleDo;
import io.restassured.common.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class MultipleTableTest {

    @Autowired
    MultipleController multipleController;

    @Test
    public void tesGetAll() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        givenRestAssuredSpecification.when().get("/multiple/getAll").then().log().all();
    }

    @Test
    public void tesGetOne() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        givenRestAssuredSpecification.param("id", 2).when().get("/multiple/getOne").then().log().all();
    }

    @Test
    public void testJsonString() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        String id = givenRestAssuredSpecification.param("id", 2).when().get("/multiple/getOne").andReturn().asString();
       List<String> clos = JsonPath.from(id).get("subList.column2");
       log.info(JSON.toJSONString(clos));
    }

    @Test
    public void testStream() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        MockMvcResponse id = givenRestAssuredSpecification.param("id", 2).when().get("/multiple/getOne");
        try (InputStream inputStream = id.asInputStream()){
            byte[] bytes = inputStream.readAllBytes();
            log.info(new String(bytes));
        }catch (Exception e){

        }
    }

    @Test
    public void tesList() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        List<Map<String, Object>> as = givenRestAssuredSpecification.when().get("/multiple/getAll")
                .as(new TypeRef<List<Map<String, Object>>>() {});
        log.info(JSONObject.toJSONString(as));
    }

    @Test
    public void testPostInsert() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);

        MultipleDo.Sub one = MultipleDo.Sub.builder().column1(3331).column2("新增子行1号").column3(new Date()).build();
        MultipleDo.Sub two = MultipleDo.Sub.builder().column1(3332).column2("新增子行2号").column3(new Date()).build();
        List<MultipleDo.Sub> subs = Arrays.asList(one, two);
        MultipleDo mainnn = MultipleDo.builder().column1(111).column2("新增主行行行1").column3(new Date()).subList(subs).build();
        log.info(JSONObject.toJSONString(mainnn));
        givenRestAssuredSpecification.contentType("application/json").body(JSON.toJSONString(mainnn));
        givenRestAssuredSpecification.post("/multiple/addOne").then().log().all();
    }
}
