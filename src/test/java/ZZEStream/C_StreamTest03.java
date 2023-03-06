package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C_StreamTest03 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
                    new LightNovel("CCC", 1.99),
                    new LightNovel("AAA", 3.99),
                    new LightNovel("BBB", 2.99),
                    new LightNovel("BBB", 2.99),
                    new LightNovel("DDD", 5.99),
                    new LightNovel("EEE", 0.99)
            ));

    public static void main(String[] args) {
        Stream<LightNovel> lightNovelStream = lightNovels.stream();
//        lightNovels.forEach(System.out::println);
        long count = lightNovelStream.filter(ln -> ln.getPrice() <= 4)
                .count();
        long count2 = lightNovels.stream()
                .distinct()
                .filter(ln -> ln.getPrice() <= 4)
                .count();
        System.out.println(count);
        System.out.println(count2);
    }
}

