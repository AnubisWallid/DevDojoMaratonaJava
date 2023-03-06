package ZZCLambdas;

import ZZCLambdas.Dominio.Anime;
import ZZCLambdas.Servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class E_MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> animes = new ArrayList(
                List.of(
                        "Bersek",
                        "Naruto",
                        "Death Note",
                        "Hellsing"
                )
        );
        Function<String,Integer> numStringToInterger = Integer::parseInt;
        System.out.println(numStringToInterger.apply("1000"));
        BiPredicate<List<String>,String> checkName = List::contains;
        System.out.println(checkName.test(animes,"Naruto"));

    }
}