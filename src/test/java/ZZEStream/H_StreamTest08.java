package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class H_StreamTest08 {
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
        //Soma de todos os precos acima de 3
        lightNovels.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);
        lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .sum();
    }
}

