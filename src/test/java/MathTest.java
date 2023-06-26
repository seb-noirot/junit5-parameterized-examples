import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class MathTest {

    @ParameterizedTest(name = "Test #{index}: {0} + {1} = {2}")
    @CsvSource({"2, 3, 5", "4, 5, 9", "10, 20, 30"})
    void testSum(int a, int b, int expectedSum) {
        assertEquals(expectedSum, a + b);
    }


    @ParameterizedTest
    @CsvSource(textBlock = """
        2, 3, 5
        4, 5, 9
        10, 20, 30
    """)
    public void testSumWithTextBlock(int a, int b, int expectedSum) {
        assertEquals(expectedSum, a + b);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        a, b, sum
        2, 3, 5
        4, 5, 9
        10, 20, 30
    """, useHeadersInDisplayName = true)
    void testSumTextBlockWithHeaders(int a, int b, int expectedSum) {
        assertEquals(expectedSum, a + b);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input.csv")
    void testSumFromCsvFile(int a, int b, int expectedSum) {
        assertEquals(expectedSum, a + b);
    }
}