package ZZKJunit.service;

import ZZKJunit.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    PersonService personService;

    @BeforeEach
    public void setUp() {
        adult = new Person(18);
        notAdult = new Person(16);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Assertions.assertEquals(false, personService.isAdult(notAdult));
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equals than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrEqualsThan18() {
        Assertions.assertEquals(true, personService.isAdult(adult));
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw NullPointer with message when person is null")
    void isAdult_ShouldThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> personService.isAdult(null), "Person can`t be null");
    }

    @Test
    @DisplayName("Return all persons on list when person are lower than 18")
    void filterRemovingNotAdult_AllOnListOfPersons() {
        List<Person> notAdult = personService.filterRemovingNotAdult(List.of(
                new Person(12),
                new Person(13),
                new Person(18),
                new Person(19)));
        Assertions.assertEquals(2, notAdult.size());
        for (Person p : notAdult) {
            Assertions.assertTrue(personService.isAdult(p));
        }
    }
}