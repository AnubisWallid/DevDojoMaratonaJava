package ZZCLambdas.Servico;

import ZZCLambdas.Dominio.Anime;

public class AnimeComparators {
    public static int compareByTitle(Anime a1, Anime a2){
        return a1.getTitle().compareToIgnoreCase(a2.getTitle());
    }
    public static int compareByEpisodes(Anime a1, Anime a2){
        return Integer.compare(a1.getEpisodes(),a2.getEpisodes());
    }
    public int compareBySecondLetterNonStatic(Anime a1, Anime a2){
        return Character.compare(a1.getTitle().charAt(1),a2.getTitle().charAt(1));
    }
}
