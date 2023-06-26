import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NameTest {

@ParameterizedTest
@CsvSource(value = {"'', Smith"}, emptyValue = "Unknown")
void testName(String firstName, String lastName) {
    Assertions.assertEquals("Unknown", firstName);
}

@ParameterizedTest
@CsvSource(value = {"NULL, Smith"}, nullValues = "NULL")
void testNameWithNulls(String firstName, String lastName) {
    Assertions.assertNull(firstName);
}
}
