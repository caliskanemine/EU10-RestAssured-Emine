package com.cybertek.Day11;

import org.junit.jupiter.api.*;

public class TestLifeCycleAnnotations {

    //beforeClass is testNg version of beforeAll, same logic
    @BeforeAll  //junit
    public static void init(){
    }

    @AfterEach
    public void closeEach(){
        System.out.println("After each is running");
    }

    @BeforeEach //beforeMethod is testNg version of beforeEach, same logic
    public void initEach(){
        System.out.println("Before each is running");
    }

    @Test
    public void test1(){

        System.out.println("Test 1 is running");
    }

    @Disabled //ignores that test
    @Test
    public void test2(){

        System.out.println("Test 2 is running");
    }

    @AfterAll //junit
    public static void close(){
        System.out.println("After all is running");
    }


}
