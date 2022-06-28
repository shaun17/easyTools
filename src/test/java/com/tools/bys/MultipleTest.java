package com.tools.bys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tools.bys.biz.generator.domain.TSub;
import com.tools.bys.controller.MultipleController;
import com.tools.bys.controller.SingleController;
import com.tools.bys.vo.MultipleDo;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.response.ValidatableMockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class MultipleTest {

    @Autowired
    MultipleController multipleController;

    @Test
    public void getMethod1() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        givenRestAssuredSpecification.when().get("/multiple/getAll").then().log().all();
    }

    @Test
    public void getMethod2() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        givenRestAssuredSpecification.param("id", 2).when().get("/multiple/getOne").then().log().all();
    }

    @Test
    public void getMethod3() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);
        String id = givenRestAssuredSpecification.param("id", 2).when().get("/multiple/getOne").andReturn().asString();
       List<String> clos = JsonPath.from(id).get("subList.column2");
       log.info(JSON.toJSONString(clos));
    }

    @Test
    public void postMethod1() {
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
