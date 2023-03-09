package ZZHPadroesDeProjetos;

import ZZHPadroesDeProjetos.Dominio.Person;

public class A_BuilderPatternTest01 {
    public static void main(String[] args) {
        Person personBuild = Person.PersonBuilder
                .builder()
                .firstName("Wallid")
                .lastName("Santana")
                .userName("XxwallidxX")
                .email("wallid@email.com")
                .build();
        System.out.println(personBuild);
    }
}
