import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 1, 2",
            "2, 3, 5",
            "100, 200, 300"
    })
    void testAddition(int a, int b, int expectedResult) {
        assertEquals(expectedResult, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 : 3 : 5", "4 : 5 : 9"}, delimiter = ':')
    void testSumWithCustomDelimiter(int a, int b, int expectedSum) {
        assertEquals(expectedSum, a + b);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 || 3 || 5", "4 || 5 || 9"}, delimiterString = "||")
    void testSumWithCustomDelimiterString(int a, int b, int expectedSum) {
        assertEquals(expectedSum, a + b);
    }


    private static class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}