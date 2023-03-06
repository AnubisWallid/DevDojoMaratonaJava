package ZZEStreamCollectors;

import ZZEStream.Dominio.Category;
import ZZEStream.Dominio.LightNovel;
import ZZEStream.Dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class E_StreamCollectorsTest05 {
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
        Map<Category, DoubleSummaryStatistics> summaryStatisticsMap = lightNovels.stream()
                .collect(
                        groupingBy(
                                LightNovel::getCategory,
                                Collectors.summarizingDouble(LightNovel::getPrice)
                        )
                );
        System.out.println(summaryStatisticsMap);

        Map<Category, LinkedHashSet<Promotion>> collect = lightNovels.stream()
                .collect(
                        groupingBy(
                                LightNovel::getCategory,
                                mapping(E_StreamCollectorsTest05::getPromotion,
                                        Collectors.toCollection(LinkedHashSet::new))
                                //Collectors.toList())// -> Map<Category, List<Promotion>>
                                //Collectors.toSet())// -> Map<Category, Set<Promotion>>
                        )
                );
        System.out.println(collect);
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
