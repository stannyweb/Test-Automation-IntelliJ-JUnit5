package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class TaggedTestClass {

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
    @Tag("sanity")
    @DisplayName("US2 - TC2 - This is the first method")
//    USER STORY 2 - TEST CASE 2 - Name of the method.
    void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US1 - TC1 - This is the second method")
//    USER STORY 1 - TEST CASE 1 - Name of the method.
    void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @Tag("acceptance")
    void thirdMethod() {
        System.out.println("This is the third method");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam) {
//        Тества дали методът правилно обработва различни цели числа като входни данни.
        System.out.println("theParams = " + theParam);
    }
}
