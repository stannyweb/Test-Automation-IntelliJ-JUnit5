package junit5tests;

import org.junit.jupiter.api.*;

public class MiscTests {


    @Test
    @Timeout(5)
    void timeOut() throws InterruptedException {
        System.out.println("This test uses timeout");
        Thread.sleep(6000);
    }

    @MyAnnotation
    void customTestWithAnnotation() {
        System.out.println("This test uses custom annotation");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest {

        @BeforeAll
        void beforeAllMethod() {
            System.out.println("Before all in nested class");
        }

        @Test
        void nestedTestMethod() {
            System.out.println("Nested test method");
        }
    }
}
