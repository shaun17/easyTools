package com.tools.bys;

import com.tools.bys.controller.SingleController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class JsonTest {

    @Autowired
    SingleController singleController;

    @Test
    public void testGetAll() {
        MockMvcRequestSpecification givenRestAssuredSpecification = RestAssuredMockMvc.given()
                .standaloneSetup(singleController);
        givenRestAssuredSpecification.when().get("/single/getAll")
                .then().assertThat().body(matchesJsonSchemaInClasspath("template.json"));
    }
}
