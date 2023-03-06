package ZZEStreamCollectors;

import ZZEStream.Dominio.Category;
import ZZEStream.Dominio.LightNovel;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class D_StreamCollectorsTest04 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
                    new LightNovel("CCC", 1.99, Category.DRAMA),
                    new LightNovel("AAA", 3.99, Category.FANTASY),
                    new LightNovel("BBB", 2.99, Category.ROMANCE),
                    new LightNovel("FFF", 8.99, Category.ROMANCE),
                    new LightNovel("BBB", 2.99, Category.ROMANCE),
                    new LightNovel("DDD", 5.99, Category.DRAMA),
                    new LightNovel("EEE", 0.99, Category.FANTASY)
            ));

    public static void main(String[] args) {
        Map<Category, Long> collect1 = lightNovels.stream().collect(
                groupingBy(LightNovel::getCategory,
                        Collectors.counting()));
        System.out.println(collect1);
        Map<Category, Optional<LightNovel>> collect2 = lightNovels.stream()
                .collect(
                        groupingBy(LightNovel::getCategory,
                                Collectors.maxBy(
                                        Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect2);
        Map<Category, LightNovel> collect3 = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(LightNovel::getPrice)),
                                Optional::get)));
        System.out.println(collect3);
        Map<Category, LightNovel> collect4 = lightNovels.stream()
                .collect(Collectors.toMap(
                        LightNovel::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));

    }
}
