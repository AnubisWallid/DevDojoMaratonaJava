package ZZAClassesInternas;

import ZGenereics.Dominio.Carro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CarroNomeComparator implements Comparator<Carro> {

    @Override
    public int compare(Carro o1, Carro o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class D_AnonymousClassTest02 {
    public static void main(String[] args) {
        List<Carro> carList = new ArrayList<>(List.of(
                new Carro("Van"),
                new Carro("Fusca"),
                new Carro("Onibus"),
                new Carro("Tanque")
        ));
        CarroNomeComparator comparator = new CarroNomeComparator();
        carList.sort(
                new Comparator<Carro>() {
                    @Override
                    public int compare(Carro o1, Carro o2) {
                        return o2.getNome().compareTo(o1.getNome());//Ordem inversa
                    }
                }
        );
        System.out.println(carList);

    }
}

