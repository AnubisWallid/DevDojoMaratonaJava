package ZZKJunit.test;

import ZZKJunit.domain.Person;
import ZZKJunit.service.PersonService;

public class PersonTest01 {
    public static void main(String[] args) {
        Person person = new Person(17);
        PersonService personService = new PersonService();
        personService.isAdult(person);
    }
}
