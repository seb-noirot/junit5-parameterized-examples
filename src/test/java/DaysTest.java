import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class DaysTest {

    enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    @ParameterizedTest
    @EnumSource(Days.class)
    void testDaysEnum(Days days) {
        assertNotNull(days);
    }

    @ParameterizedTest
    @EnumSource(value = Days.class, mode = EnumSource.Mode.INCLUDE, names = {"MONDAY", "FRIDAY"})
    public void testIncludeMode(Days day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource(value = Days.class, mode = EnumSource.Mode.EXCLUDE, names = {"SATURDAY", "SUNDAY"})
    void testExcludeMode(Days day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource(value = Days.class, mode = EnumSource.Mode.MATCH_ALL, names = {"^.*DAY$", "^MON.*"})
    void testMatchAllMode(Days day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource(value = Days.class, mode = EnumSource.Mode.MATCH_ANY, names = {"^TUES.*", "^FRI.*"})
    void testMatchAnyMode(Days day) {
        assertNotNull(day);
    }
}