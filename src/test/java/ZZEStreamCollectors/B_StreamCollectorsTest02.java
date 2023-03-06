package ZZEStreamCollectors;

import ZZEStream.Dominio.Category;
import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class B_StreamCollectorsTest02 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
                    new LightNovel("CCC", 1.99, Category.DRAMA),
                    new LightNovel("AAA", 3.99, Category.FANTASY),
                    new LightNovel("BBB", 2.99, Category.ROMANCE),
                    new LightNovel("BBB", 2.99, Category.ROMANCE),
                    new LightNovel("DDD", 5.99, Category.DRAMA),
                    new LightNovel("EEE", 0.99, Category.FANTASY)
            ));

    public static void main(String[] args) {
        Map<Category, List<LightNovel>> categoryLightNovelsMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()) {
                case DRAMA -> {
                    drama.add(lightNovel);
                }
                case FANTASY -> {
                    fantasy.add(lightNovel);
                }
                case ROMANCE -> {
                    romance.add(lightNovel);
                }
            }
        }
        System.out.println(drama);
        System.out.println(fantasy);
        System.out.println(romance);
        categoryLightNovelsMap.put(Category.DRAMA,drama);
        categoryLightNovelsMap.put(Category.FANTASY,fantasy);
        categoryLightNovelsMap.put(Category.ROMANCE,romance);
        System.out.println(categoryLightNovelsMap);
        Map<Category, List<LightNovel>> categoryListMap = lightNovels.stream()
                .collect(
                        Collectors.groupingBy(LightNovel::getCategory));
        System.out.println(categoryListMap);

    }
}
