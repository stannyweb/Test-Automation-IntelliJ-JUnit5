package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(PER_CLASS)
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

    @ParameterizedTest(name = "Hero #{index} - {arguments}")
    @CsvSource(value = {"Steve,Rogers", "Stan,Angelov", "Mariya,Gurdarshan"})
    void csvSource_StringString(String param1, String param2) {
//        Всеки ред в @CsvSource представлява един тест, където първият низ е param1, а вторият е param2.
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    /**
     * Всеки ред в @CsvSource представлява един тест, където:
     *
     * @param param1 първата стойност е име (String)
     * @param param2 втората стойност е възраст (int)
     * @param param3 третата стойност е разрешение (boolean)
     */
    @ParameterizedTest(name = "name: {0} - age: {1} - isAllowed: {2}")
    @CsvSource(value = {"Stan,33,true", "Mariya,36,true", "Angelov,55,false"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDiffDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppingList.csv",
            "src/test/resources/params/shoppingList2.csv"}, numLinesToSkip = 1)
    void csvFileSource_ShoppingList(String name, double price, int quantity, String units, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", units = " + units + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppingList3.csv", numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_ShoppingListWithDelimiter(String name, double price, int quantity, String units, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", units = " + units + ", provider = " + provider);
    }


    @ParameterizedTest(name = "Vegetable: {0} - price: {1}")
    @MethodSource(value = "methodSourceList")
    void methodSource_List(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<Arguments> methodSourceList() {
//        processing
        return Arrays.asList(arguments("tomato", 5.4), arguments("carrot", 1.4));
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamsProvider#methodSourceStream")
    void methodSource_StreamString(String param1) {
//        Използва се @MethodSource за да укаже, че входните данни идват от метод в класа ParamsProvider.
//        "junit5tests.ParamsProvider#methodSourceStream" указва пълното име на метода, който предоставя данните.
        System.out.println("param1 = " + param1);
    }


}
