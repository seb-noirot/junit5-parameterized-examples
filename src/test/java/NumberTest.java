import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 16, 32})
    void testNumberIsPowerOfTwo(int number) {
        assertTrue(isPowerOfTwo(number));
    }

    private boolean isPowerOfTwo(int number) {
        return (number & (number - 1)) == 0;
    }
}