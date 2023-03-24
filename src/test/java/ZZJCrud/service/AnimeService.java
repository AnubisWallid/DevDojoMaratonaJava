package ZZJCrud.service;

import ZZJCrud.domain.Anime;
import ZZJCrud.domain.Producer;
import ZZJCrud.repository.AnimeRepository;
import ZZJCrud.repository.ProducerRepository;

import java.util.Scanner;

public class AnimeService {
    private final Scanner SCANNER = new Scanner(System.in);
    private final AnimeRepository animeRepository = new AnimeRepository();
    private final ProducerRepository producerRepository = new ProducerRepository();

    public void builderMenu(int operacao) {
        switch (operacao) {
            case 1 -> createAnime();
            case 2 -> findByName();
            case 3 -> updateAnime();
            case 4 -> deleteAnime();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }

    private void createAnime() {
        System.out.println("=== Create Anime ===");
        System.out.print("Enter Name: ");
        String name = SCANNER.nextLine();
        System.out.print("Enter Episodes: ");
        int episodes = SCANNER.nextInt();
        System.out.print("Enter ID Producer: ");
        Integer producer_id = SCANNER.nextInt();
        Anime anime = Anime.builder()
                .name(name)
                .episodes(episodes)
                .producer(Producer.builder().id(producer_id).build())
                .build();
        animeRepository.save(anime);
    }

    private void findByName() {
        System.out.println("=== Read Anime ===");
        System.out.print("Type the Name or Empty to all: ");
        String name = SCANNER.nextLine();
        if (name.isEmpty() || name.isBlank()) name = "";
        System.out.println("=== Animes ===");
        animeRepository.findByName(name).forEach(anime ->
                System.out.printf("ID: '%d' NAME: '%s', EPISODES: '%d', PRODUCER: '%s'%n",
                        anime.getId(),
                        anime.getName(),
                        anime.getEpisodes(),
                        anime.getProducer().getName()));
    }

    private void updateAnime() {
        System.out.println("=== Update Anime ===");
        System.out.println("Set new Name: ");
        String name = SCANNER.nextLine();
        System.out.println("Set new Episodes: ");
        int episodes = SCANNER.nextInt();
        System.out.println("Set Anime ID: ");
        Integer id = SCANNER.nextInt();
        System.out.printf("Update ID: '%d', NAME: '%s', EPISODES: '%d' ? Y or N ?%n", id, name, episodes);
        if (SCANNER.next().equalsIgnoreCase("n")) return;
        Anime anime = Anime.builder().id(id).name(name).episodes(episodes).build();
        animeRepository.update(anime);
    }

    private void deleteAnime() {
        System.out.println("=== Delete Anime ===");
        System.out.print("Enter ID: ");
        int id = SCANNER.nextInt();
        animeRepository.delete(id);
    }
}
