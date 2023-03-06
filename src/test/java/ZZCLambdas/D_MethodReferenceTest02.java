package ZZCLambdas;

import ZZCLambdas.Dominio.Anime;
import ZZCLambdas.Servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class D_MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
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

    }
}