package ZZDOptional.Repositorio;

import ZZDOptional.Dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CarRepository {
    private static List<Car> listCars = new ArrayList<>(List.of(
            new Car("Red",1),
            new Car("Brown",2),
            new Car("Violet",3),
            new Car("LightGray",4))
    );
    public Optional<Car> findCarByColor(String color){
        return findCarBy(car -> car.getColor().equalsIgnoreCase(color));
    }
    public Optional<Car> findCarByYear(int year){
        return findCarBy(car -> car.getYear() == year);
    }

        public Optional<Car> findCarBy(Predicate<Car> predicate){
        Car found = null;
        for (Car car: listCars) {
            if (predicate.test(car)){
                found = car;
            }
        }
        return Optional.ofNullable(found);
    }
    public int lastListItem(){

        int i = listCars.size();
        return listCars.isEmpty()? 0 : i;
    }
    public void add(Car car){
        listCars.add(car);
    }

    @Override
    public String toString() {
        return listCars.toString();
    }
}
