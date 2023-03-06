package ZZCLambdas;

import ZZCLambdas.Dominio.Anime;
import ZZCLambdas.Servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class D_MethodReferenceTest04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> animeComparatorsSupplier = AnimeComparators::new;
        AnimeComparators animeComparators = animeComparatorsSupplier.get();
        List<Anime> animes = new ArrayList(
                List.of(
                        new Anime("Bersek", 43),
                        new Anime("Naruto", 500),
                        new Anime("Hellsing", 12)
                )
        );
        //Instancia de um objeto
        animes.sort(animeComparators::compareBySecondLetterNonStatic);
        System.out.println(animes);
        BiFunction<String,Integer,Anime> animeBiFunction1 = (title,episodes) -> new Anime(title, episodes);
        BiFunction<String,Integer,Anime> animeBiFunction2 = Anime::new;
        animes.add(animeBiFunction2.apply("Death Note",13));
        System.out.println(animes);

    }
}