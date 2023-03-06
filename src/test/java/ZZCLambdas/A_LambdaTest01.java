package ZZCLambdas;

import java.util.List;
import java.util.function.Consumer;

public class A_LambdaTest01 {
    public static void main(String[] args) {
        List<String> names = List.of("A","B","C");
//        forEach(names, System.out::println);
        forEach(names,(String s) -> System.out.println(s));
    }
    // Consumer não retorna nadaa

    private static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }

    }
}
