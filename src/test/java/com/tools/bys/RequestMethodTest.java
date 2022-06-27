package com.tools.bys;

import com.tools.bys.controller.SingleController;
import io.restassured.http.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.*;

/**
 * 先启项目，通过启动项目测试接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RequestMethodTest {

    @Test
    public void request_method_accepts_enum_verb() {
        given().param("id",1).when().get("/single/getOne").then().log().all();
    }
}

