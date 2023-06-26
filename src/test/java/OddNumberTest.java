import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class OddNumberTest {

    @ParameterizedTest
    @MethodSource("provideOdds")
    void testIsOdd(int number) {
        assertTrue(isOdd(number));
    }

    private static Stream<Integer> provideOdds() {
        return Stream.of(1, 2, 3, 5, 7, 9, 11);
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
