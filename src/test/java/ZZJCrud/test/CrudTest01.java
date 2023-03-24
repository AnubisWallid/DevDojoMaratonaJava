package ZZJCrud.test;

import ZZJCrud.service.AnimeService;
import ZZJCrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation;
        ProducerService producerService = new ProducerService();
        AnimeService animeService = new AnimeService();
        while (true) {
            System.out.print("""
                    ============== Menu Services ==============
                    1. Work to Producer.
                    2. Work to Anime.
                    0. Exit.
                    """);
            int menu = scanner.nextInt();
            if (menu == 1) {
                producerMenu();
                operation = scanner.nextInt();
                if (operation == 9) continue;
                if (operation == 0) break;
                producerService.builderMenu(operation);
            } else if (menu == 2) {
                animeMenu();
                operation = scanner.nextInt();
                if (operation == 9) continue;
                if (operation == 0) break;
                animeService.builderMenu(operation);
            }
            if (menu == 0) break;
        }
    }

    private static void producerMenu() {
        System.out.print(
                """
                        ========= Menu Producer =========
                        1. CREATE a Producer.
                        2. READ a Producer.
                        3. UPDATE a Producer.
                        4. DELETE by ID.
                        9. Back main MENU.
                        0. Exit.
                        Enter the Operation Number:\040""");
    }

    private static void animeMenu() {
        System.out.print(
                """
                        =========== Menu Anime ===========
                        1. CREATE a Anime.
                        2. READ a Anime.
                        3. UPDATE a Anime.
                        4. DELETE by ID.
                        9. Back main MENU.
                        0. Exit.
                        Enter the Operation Number:\040""");
    }
}

