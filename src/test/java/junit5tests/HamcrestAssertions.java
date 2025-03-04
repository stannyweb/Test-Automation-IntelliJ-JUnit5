package junit5tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestAssertions {

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 1);

        assertThat(theMap, hasKey("thirdKey"));
        assertThat(theMap, hasValue(2));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("String1", "String2", "String3");

        assertThat(theList, containsInAnyOrder("String2", "String3", "String1"));
    }

    @Test
    void assertForAnyInList() {
        List<String> theList = Arrays.asList("String1", "String2", "String3");

        assertThat(theList, anyOf(hasItem("String1"), hasItem("NoString")));
    }

    @Test
    void assertForAllInList() {
        List<String> theList = Arrays.asList("String1", "String2", "String3");

        assertThat(theList, allOf(hasItem("String1"), hasItem("String2"), hasItem("String3")));
    }
}
