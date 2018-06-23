package com.testng.demo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TestNGDemo1 {
    @Test(dataProvider = "testDataProvider")
    public void testDataProvider(String username, String password){
        System.out.println("username "+username+"\t"+"passord "+password);
    }
    @DataProvider
    public Object[][] testDataProvider(){
        return new Object[][]{
                {"rongrong","123456"},
                {"xiaoqiang","123456"},
                {"aaa","243243"}
        };
    }

    int i;
    @Test
    public void setValue(){
        i=10;
    }
    @Test(dependsOnMethods = "setValue")
    public void getValue() {
        System.out.println(i);
    }
    @Test(enabled = false)
    public void testignore(){
        System.out.println("ignore");
    }
}
