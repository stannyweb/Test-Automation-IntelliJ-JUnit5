package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam) {
//        Тества дали методът правилно обработва различни цели числа като входни данни.
        System.out.println("theParams = " + theParam);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParam) {
//        Тества дали методът правилно обработва null, празен низ и други низове като входни данни.
        System.out.println("theParam = " + theParam);
    }
}
