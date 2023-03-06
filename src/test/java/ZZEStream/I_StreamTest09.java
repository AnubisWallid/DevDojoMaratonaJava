package ZZEStream;

import ZGenereics.Dominio.Barco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class I_StreamTest09 {
    public static void main(String[] args) {
        IntStream.range(1,50).filter(n -> n%2 ==0).forEach(System.out::print);
        //2 -> 48
        IntStream.rangeClosed(1,50).filter(n -> n%2 ==0).forEach(System.out::print);
        //2 -> 50
        Stream.of(new Barco("Lancha"),
                new Barco("Canoa"),
                new Barco("Iate"),
                new Barco("Navio"))
                .map(s-> s.getNome().toUpperCase())
                .sorted()
                .forEach(System.out::println);

        try (Stream<String> lines = Files.lines(Paths.get("Teste.txt"))) {
            lines.filter(l -> l.contains("A B C")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
