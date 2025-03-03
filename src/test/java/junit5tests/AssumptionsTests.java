package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTests {

    @ParameterizedTest(name = "name: {0} - age: {1} - isAllowed: {2}")
    @CsvSource(value = {"Stan,33,true", "Mariya,36,true", "Angelov,55,false"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {

        assumeTrue(param2 > 40, "The age is not greater than 40");

        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppingList.csv",
            "src/test/resources/params/shoppingList2.csv"}, numLinesToSkip = 1)
    void csvFileSource_ShoppingList(String name, double price, int quantity, String units, String provider) {

        assumingThat(quantity > 2, () -> System.out.println("The quantity is greater than 2..."));

        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", units = " + units + ", provider = " + provider);
    }
}
