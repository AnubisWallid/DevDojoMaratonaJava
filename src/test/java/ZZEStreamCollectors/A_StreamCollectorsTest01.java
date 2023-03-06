package ZZEStreamCollectors;

import ZZB_Comportamento.Dominio.Car;

import java.text.Format;
import java.util.*;
import java.util.stream.Collectors;

public class A_StreamCollectorsTest01 {
    private static List<Car> carsList = new ArrayList<>(List.of(
            new Car("Blue", 1870),
            new Car("Red", 2019),
            new Car("Black", 1995),
            new Car("Yellow", 2015),
            new Car("Purple", 2021),
            new Car("Red", 2010),
            new Car("Gray", 2016)));


    public static void main(String[] args) {
        System.out.println("22 - " +
                carsList.stream()
                        .count()
        );
        System.out.print("27 - ");
        carsList.stream()
                .max(Comparator.comparing(Car::getYear))
                .ifPresent(System.out::println);
        System.out.println("31 - " +
                carsList.stream()
                        .collect(Collectors.maxBy(Comparator.comparing(Car::getYear))));
        System.out.println("34 - " +
                carsList.stream()
                        .collect(Collectors.summarizingDouble(Car::getYear)));
        DoubleSummaryStatistics collect =
                carsList.stream()
                        .collect(Collectors.summarizingDouble(Car::getYear));
        System.out.printf("""
                42 - Contador: %d
                     Soma:  %s
                     Maximo %s
                     Minimo %s
                     Media: %s%n""",
                collect.getCount(),
                collect.getSum(),
                collect.getMax(),
                collect.getMin(),
                collect.getAverage());
        System.out.println("44 - " +
                carsList.stream()
                        .map(Car::getColor)
                        .collect(Collectors.joining(", ")));
    }
}
