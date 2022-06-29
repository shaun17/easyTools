package com.tools.bys;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static io.restassured.RestAssured.*;

/**
 * 先启项目，通过启动的项目测试接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RequestMethodTest {

    @Test
    public void requestMethod1() {
        given().param("id",1).when().get("/single/getOne").then().log().all();
    }

    @Test
    public void testCookie() {
        Cookie build = new Cookie.Builder("username", "admin").setComment("txt").build();
        Cookie build2 = new Cookie.Builder("username", "admin").setComment("txt").build();
        Cookies cookies = new Cookies(build2, build);
        given().cookies(cookies).when().get("/single/getAll").then().log().all();

        given().cookie("username","admin").when().get("/single/getAll").then().log().all();

    }

    @Test
    public void testHeader() {
        given().header("sessionId","123").when().get("/single/getAll").then().log().all();
    }




}

