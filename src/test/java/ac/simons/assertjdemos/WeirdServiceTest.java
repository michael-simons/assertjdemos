package ac.simons.assertjdemos;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeirdServiceTest {

    final WeirdService weirdService = new WeirdService();

    @Test
    @DisplayName("What to do? JUnit 5 or AssertJ?")
    public void demonstrateExceptionHandling() {
        // JUnit 5
        UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class, () -> weirdService.getSomething());
        assertEquals("This is unsupported", e.getMessage());

        // AssertJ
        assertThatThrownBy(() -> weirdService.getSomething())
            .isInstanceOf(UnsupportedOperationException.class)
            .withFailMessage("This is unsupported");
    }

    @Test
    @DisplayName("Sometimes you have service that is just... weird. Here it returns objects")
    public void niceTypeChecks() {
        assertThat(weirdService.getAString())
            .isInstanceOf(String.class)
            .asString()
            .isEqualTo("Hello");

        assertThat(weirdService.getTheRightThing())
            .isInstanceOf(List.class)
            .asList()
            .extracting("firstName")
            .containsExactly("Michael", "Christina", "Anton", "Oskar");
    }
}