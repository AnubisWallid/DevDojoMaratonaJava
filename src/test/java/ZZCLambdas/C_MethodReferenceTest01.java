package ZZCLambdas;

import ZZCLambdas.Dominio.Anime;
import ZZCLambdas.Servico.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class C_MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animes = new ArrayList(
                List.of(
                        new Anime("Bersek", 43),
                        new Anime("Naruto", 500),
                        new Anime("Hellsing", 12)
                )
        );

        //Metodos estatic chama pela classe

        animes.sort((a1, a2) -> a1.getTitle().compareToIgnoreCase(a2.getTitle()));
        System.out.println(animes);

        Collections.sort(animes, Comparator.comparingInt(Anime::getEpisodes));
        System.out.println(animes);

        Collections.sort(animes, Comparator.comparingInt(anime -> anime.getEpisodes()));
        System.out.println(animes);

        Collections.sort(animes, AnimeComparators::compareByTitle);
        System.out.println(animes);

        Collections.sort(animes, (a1, a2) -> AnimeComparators.compareByTitle(a1, a2));
        System.out.println(animes);

    }
}