package pl.coderslab.test;

import org.junit.jupiter.api.*;

public class JunitExample {
    @Test
    public void firstTest() {
        System.out.println("first test");
    }

    @Disabled
    @Test
    public void secondTest() {
        System.out.println("second test");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("this will be run before each test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("this will be run after each test");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("this will be run before All tests once");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("this will be run after All tests once");
    }
}
