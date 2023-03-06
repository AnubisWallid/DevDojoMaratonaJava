package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class F_StreamTest06 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
                    new LightNovel("CCC", 1.99),
                    new LightNovel("AAA", 3.99),
                    new LightNovel("BBB", 2.99),
                    new LightNovel("FFF", 2.99),
                    new LightNovel("DDD", 5.99),
                    new LightNovel("EEE", 0.99)
            ));
    public static void main(String[] args) {
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() <  0));

        lightNovels
                .stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels
                .stream()
                .filter(ln -> ln.getPrice() < 3)
                .findFirst()
                .ifPresent(System.out::println);

    }
}

