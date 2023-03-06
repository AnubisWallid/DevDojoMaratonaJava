package ZZDOptional;

import ZZDOptional.Dominio.Car;
import ZZDOptional.Repositorio.CarRepository;

public class B_OptionalTest02 {
    public static void main(String[] args) {
        CarRepository repository = new CarRepository();
        repository.findCarByColor("Brown")
                .ifPresent(car -> {
                    car.setColor("Yellow");
                    System.out.println(car);
                });
        System.out.println(repository.findCarByYear(1));
        Car carElse = repository.findCarByYear(1).orElseThrow(IllegalArgumentException::new);
        Car car = repository.findCarByColor("Blue").orElseGet(() -> new Car("Blue", repository.lastListItem()));
        repository.add(carElse);
        repository.add(car);
        System.out.println(repository);

    }
}
