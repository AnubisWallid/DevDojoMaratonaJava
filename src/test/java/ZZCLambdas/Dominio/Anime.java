package ZZCLambdas.Dominio;

public class Anime {
    private String title;
    private int episodes;

    public Anime(String title, int quantity) {
        this.title = title;
        this.episodes = quantity;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getEpisodes() {
        return episodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anime)) return false;

        Anime anime = (Anime) o;

        return getTitle() != null ? getTitle().equalsIgnoreCase(anime.getTitle()) : anime.getTitle() == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
