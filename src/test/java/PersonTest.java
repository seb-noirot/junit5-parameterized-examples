import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @ParameterizedTest
    @ArgumentsSource(PersonArgumentsProvider.class)
    void testFullName(Person person, String expectedFullName) {
        assertEquals(expectedFullName, person.getFullName());
    }

    public static class Person {
        private final String firstName;
        private final String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFullName() {
            return firstName + " " + lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static class PersonArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new Person("John", "Doe"), "John Doe"),
                    Arguments.of(new Person("Jane", "Doe"), "Jane Doe"),
                    Arguments.of(new Person("James", "Bond"), "James Bond")
            );
        }
    }
}
