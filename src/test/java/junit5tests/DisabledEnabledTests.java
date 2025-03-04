package junit5tests;

import listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DisabledEnabledTests {

    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo of @DisabledOnOS")
    @Test
    void firstTest() {
//        Тестът се деактивира, ако се изпълнява на операционна система Windows.
        System.out.println("This is the first test");
    }

    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disabled for demo of @disabledIfSystemProperty")
    @Test
    void secondTest() {
//        Тестът се деактивира, ако системното свойство "env" е зададено на "staging".
        System.out.println("This is the second test");
    }

    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf")
    @Test
    void thirdTest() {
//        Тестът се деактивира, ако методът "provider()" връща true.
        System.out.println("This is the third test");
    }

    @Test
    void fourthTest() {
//        Този тест винаги се изпълнява, без условия за деактивиране.
        System.out.println("This is the fourth test");
    }

    @Disabled(value = "Disabled for demo of @Disabled")
    @Test
    void fifthTest() {
//        Този тест винаги е деактивиран, независимо от условията.
        System.out.println("This is the fifth test");
    }

    boolean provider() {
//        Методът връща true, ако текущият ден е понеделник.
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.MONDAY);
    }
}
