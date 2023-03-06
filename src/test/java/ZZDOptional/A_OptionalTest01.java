package ZZDOptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class A_OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> stringOptional1 = Optional.of("Dentro do Optional");
        Optional<String> stringOptional2 = Optional.ofNullable(null);
        Optional<String> stringOptional3 = Optional.empty();

        Optional<String> nameOptional = findName("Joao");
        String empty = nameOptional.orElse("EMPTY");
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
        System.out.println(empty);


    }
    /**
    private static String findName(String name){
        List<String> agenda = List.of("Marco", "Roberto", "Murilo", "Lucas");
        int i = agenda.indexOf(name);
        if (i >= 0){
            return agenda.get(i);
        }
        return null;
    }
    **/
    private static Optional<String> findName(String name){
        List<String> agenda = List.of("Marco", "Roberto", "Murilo", "Lucas");
        int i = agenda.indexOf(name);
        if (i >= 0){
            return Optional.of(agenda.get(i));
        }
        return Optional.empty();
    }
}
