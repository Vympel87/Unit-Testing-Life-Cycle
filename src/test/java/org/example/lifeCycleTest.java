package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class lifeCycleTest {
    @BeforeAll
    void initClass()
    {
        System.out.println("init class");
    }
    @BeforeEach
    void initMethod()
    {
        System.out.println("init method");
    }
    @Test
    void testMethod()
    {
        System.out.println("execute text");
    }
    @AfterEach
    void cleanMethod()
    {
        System.out.println("clean method");
    }
    @AfterAll
    void cleanClass()
    {
        System.out.println("clean class");
    }
    @Test
    void testMethod1()
    {
        System.out.println("execute method 1");
    }
    @Test
    void testMethod2()
    {
        System.out.println("execute method 2");
    }
}