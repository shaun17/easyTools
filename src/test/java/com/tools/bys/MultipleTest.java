package com.tools.bys;

import com.tools.bys.biz.generator.domain.TSub;
import com.tools.bys.controller.MultipleController;
import com.tools.bys.controller.SingleController;
import com.tools.bys.vo.MultipleDo;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
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
        givenRestAssuredSpecification.param("id",2).when().get("/multiple/getOne").then().log().all();
    }

    @Test
    public void postMethod1() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(multipleController);

        MultipleDo.Sub one = MultipleDo.Sub.builder().column1(3331).column2("新增子行1号").column3(new Date()).build();
        MultipleDo.Sub two = MultipleDo.Sub.builder().column1(3332).column2("新增子行2号").column3(new Date()).build();
        List<MultipleDo.Sub> subs = Arrays.asList(one, two);
        MultipleDo mainnn = MultipleDo.builder().column1(111).column2("新增主行行行1").column3(new Date()).subList(subs).build();
        givenRestAssuredSpecification.contentType("application/json");
        givenRestAssuredSpecification.post("/multiple/addOne",mainnn).then().log().all();
    }
}
