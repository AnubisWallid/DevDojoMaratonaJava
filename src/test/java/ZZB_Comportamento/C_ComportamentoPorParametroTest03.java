package ZZB_Comportamento;

import ZZB_Comportamento.Dominio.Car;
import ZZB_Comportamento.Interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class C_ComportamentoPorParametroTest03 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("Blue", 1870),
                new Car("Red", 2019),
                new Car("Black", 1995),
                new Car("Red", 2010),
                new Car("Gray", 2016)
        ));
        List<Integer> numeros = List.of(0,1,2,3,4,5,6,7,8,9,10);
        System.out.println(filter(cars,car -> car.getColor().equalsIgnoreCase("gray")));
        System.out.println(filter(cars,car -> car.getColor().equalsIgnoreCase("gray")));
        System.out.println(filter(cars,car -> car.getYear() > 2010));
        System.out.println(filter(numeros,numero -> numero <= 3 || numero >= 8));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> listFilted = new ArrayList<>();
        for (T next : list) {
            if (predicate.test(next)) {
                listFilted.add(next);
            }
        }
        return listFilted;
    }
}