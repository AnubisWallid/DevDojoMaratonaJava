package ZZB_Comportamento;

import ZZB_Comportamento.Dominio.Car;
import ZZB_Comportamento.Interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class B_ComportamentoPorParametroTest02 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("Blue",1870),
                new Car("Red",2019),
                new Car("Black",1995),
                new Car("Red",2010),
                new Car("Gray",2016)
        ));
        List<Car> carsFilted = new ArrayList<>();

        filter(cars, carsFilted, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equalsIgnoreCase("gray");
            }
        });
        filter(cars, carsFilted, car -> car.getYear() > 2000);
        filter(cars, carsFilted, car -> car.getColor().equalsIgnoreCase("red"));
        filter(cars, carsFilted, car -> car.getYear() < 2000);
    }
    private static void filter(List<Car> cars, List<Car> newCars, CarPredicate carPredicate) {
        ListIterator<Car> carIterator = cars.listIterator();
        while(carIterator.hasNext()){
            Car next = carIterator.next();
            if (carPredicate.test(next)){
                newCars.add(next);
            }
        }
        System.out.println(newCars);
        newCars.clear();

    }
}
