package com.testng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    /**
     * 比较值类型或者对象
     */
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
        Assert.assertEquals("1","1");
    }

    @Test
    public void testObject(){
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        Assert.assertEquals(demo1, demo2);
        Assert.assertNotNull(demo2);
    }
    class Demo{
        private String name;
        private int age;

    }
}
