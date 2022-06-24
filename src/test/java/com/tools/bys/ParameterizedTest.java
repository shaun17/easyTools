package com.tools.bys;

import com.tools.bys.biz.generator.domain.TxTest;
import com.tools.bys.biz.generator.service.TxTestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContextManager;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@SpringBootTest
public class ParameterizedTest {
    private TestContextManager testContextManager;

    @Autowired
    TxTestService service;

    private int id;
    private String colume1;
    private String colume2;

    public ParameterizedTest(int id, String colume1, String colume2) {
        this.id = id;
        this.colume1 = colume1;
        this.colume2 = colume2;
    }

    @Before
    public void testGenerateDataSponsor() throws Exception {
        this.testContextManager = new TestContextManager(getClass());
        this.testContextManager.prepareTestInstance(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2,"dalian",""},
                {7,"nanjing",""},
                {1,"beijing",""}
        });
    }

    @Test
    public void method1() {
        TxTest aOneById = service.getAOneById(id);
        Assert.assertEquals(aOneById.getColumn1(),colume1);
    }




}
