package ZZB_Comportamento;

import ZZB_Comportamento.Dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class A_ComportamentoPorParametroTest01 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("Blue",1870),
                new Car("Red",2019),
                new Car("Black",1995),
                new Car("Red",2010),
                new Car("Gray",2016)
        ));
        List<Car> carsByColorRED = new ArrayList<>();
        List<Car> carsByColorBLACK = new ArrayList<>();

        filterCars(cars, carsByColorRED, "red");
        filterCars(cars, carsByColorRED, "black");
        System.out.println("Lista 1: " + cars);
        System.out.println("Lista 2: " + carsByColorRED);
        System.out.println("Lista 3: " + carsByColorBLACK);
    }

    private static void filterCars(List<Car> cars, List<Car> newCars,String cor) {
        ListIterator<Car> carIterator = cars.listIterator();
        while(carIterator.hasNext()){
            Car next = carIterator.next();
            boolean red = next.getColor().equalsIgnoreCase(cor);
            if (red){
                newCars.add(next);
            }
        }
    }
}
