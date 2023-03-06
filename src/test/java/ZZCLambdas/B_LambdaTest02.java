package ZZCLambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class B_LambdaTest02 {
    public static void main(String[] args) {
        List<String> names = List.of("Armando","Bruno","Cleiton");
        List<Integer> integerList = map(names, (String s) -> s.length());
        System.out.println(integerList);
        List<String> upperCase = map(names, (String s) -> s.toUpperCase());
        System.out.println(upperCase);


    }

    private static <T, R> List<R> map(List<T> list, Function<T,R> func) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
           R r = func.apply(t);
           result.add(r);
        }
        return result;
    }
}
