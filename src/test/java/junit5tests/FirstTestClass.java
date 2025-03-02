package junit5tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    static void beforeAll() {
        System.out.println("--This is the beforeAll method");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("----This is the beforeEach method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("--This is afterAll method");
    }

    @AfterEach
    void afterEeach() {
        System.out.println("----This is the afterEach method");
    }


    @Test
    @DisplayName("US2 - TC2 - This is the first method")
//    USER STORY 2 - TEST CASE 2 - Name of the method.
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1 - TC1 - This is the second method")
//    USER STORY 1 - TEST CASE 1 - Name of the method.
    void secondMethod() {
        System.out.println("This is the second test method");
    }
}
