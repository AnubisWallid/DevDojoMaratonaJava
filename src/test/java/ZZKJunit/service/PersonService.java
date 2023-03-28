package ZZKJunit.service;

import ZZKJunit.domain.Person;

import java.util.List;
import java.util.Objects;

public class PersonService {
    public boolean isAdult(Person person){
        Objects.requireNonNull(person,"Person can`t be null");
        return person.getAge() >= 18;
    }
    public List<Person> filterRemovingNotAdult(List<Person> persons){
        return persons.stream().filter(this::isAdult).toList();
    }
}
