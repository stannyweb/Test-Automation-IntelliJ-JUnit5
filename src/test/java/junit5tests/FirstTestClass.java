package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {

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
