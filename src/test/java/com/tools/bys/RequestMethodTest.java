package com.tools.bys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.*;

/**
 * 先启项目，通过启动项目测试接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RequestMethodTest {

    @Test
    public void requestMethod1() {
        given().param("id",1).when().get("/single/getOne").then().log().all();
    }

}

