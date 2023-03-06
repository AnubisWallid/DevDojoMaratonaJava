package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class A_StreamTEst01 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
            new LightNovel("CCC", 1.99),
            new LightNovel("AAA", 3.99),
            new LightNovel("BBB", 2.99),
            new LightNovel("DDD", 5.99),
            new LightNovel("EEE", 0.99)
            ));

    public static void main(String[] args) {
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        System.out.println(lightNovels);
        List<String> threeNovelsBytitles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            if(lightNovel.getPrice() <= 4 && threeNovelsBytitles.size() < 3){
                threeNovelsBytitles.add(lightNovel.getTitle());
            }
        }
        System.out.println(threeNovelsBytitles);

    }
}

