package junit5tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTests {

    @Test
    void assertEqualsTest() {
        assertEquals("first String", "Second String", "The string values are not equal!");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("String1", "String2", "String3");
        List<String> actualValues = Arrays.asList("String1", "String2", "String3");

        assertEquals(expectedValues, actualValues, "The values do not match!");
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 2, 3};
        int[] actualValues = {1, 5, 3};

        assertArrayEquals(expectedValues, actualValues, "Some of the values are not equal");
    }

    @Test
    void assertTrueTest() {
        assertTrue(false, "The boolean did not passed evaluation");
    }

    @Test
    void assertThrowTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTests() {
        assertAll(() -> assertEquals("first String", "Second String", "The string values are not equal!"),
                () -> assertTrue(false, "The boolean did not passed evaluation"),
                () -> assertThrows(NullPointerException.class, null));
    }
}
