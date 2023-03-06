package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class G_StreamTest07 {
    public static List<Integer> numbers = new ArrayList<>(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    public static void main(String[] args) {
        numbers.stream()
                .reduce((x, y) -> x + y)
                .ifPresent(System.out::println);

        System.out.println(numbers.stream()
                .reduce(1, (x, y) -> x + y));

        numbers.stream()
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
        System.out.println("---------------");

        numbers.stream()
                .reduce((x, y) -> x > y? x:y)
                .ifPresent(System.out::println);

        System.out.println(numbers
                .stream()
                .reduce(0,Integer::max));
    }
}

