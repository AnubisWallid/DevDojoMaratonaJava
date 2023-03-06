package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B_StreamTest02 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
            new LightNovel("CCC", 1.99),
            new LightNovel("AAA", 3.99),
            new LightNovel("BBB", 2.99),
            new LightNovel("DDD", 5.99),
            new LightNovel("EEE", 0.99)
            ));

    public static void main(String[] args) {
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle)
                .collect(Collectors.toList());
        System.out.println(titles);
    }
}

