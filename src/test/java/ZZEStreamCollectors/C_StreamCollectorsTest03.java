package ZZEStreamCollectors;

import ZZEStream.Dominio.Category;
import ZZEStream.Dominio.LightNovel;
import ZZEStream.Dominio.Promotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C_StreamCollectorsTest03 {
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
        Map<Promotion, Map<Category, List<LightNovel>>> promotionListMap = lightNovels.stream()
                .collect(Collectors.groupingBy(C_StreamCollectorsTest03::getPromotion,
                        Collectors.groupingBy(LightNovel::getCategory)
                ));

        System.out.println(promotionListMap);

    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}
