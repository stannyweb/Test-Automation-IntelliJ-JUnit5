package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {

    @RepeatedTest(5)
    void firstRepeatedMethod() {
//        Изпълнява теста 5 пъти.
        System.out.println("We are repeating this test");
    }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition} Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondRepeatedMethod() {
//         Изпълнява теста 3 пъти, като показва информация за текущото и общото повторение.
//         Има и DisplayName, което ще покаже името на теста.
        System.out.println("We are repeating new test");
    }

    @RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo) {
//        Изпълнява теста 3 пъти и използва RepetitionInfo за достъп до информация за текущото повторение.
//        Условно изпълнява код само при второто повторение.
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 2,
                () -> System.out.println("This code only runs for repetition 2"));
    }
}
