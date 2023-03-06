package ZGenereics;

import ZGenereics.Dominio.Animal;
import ZGenereics.Dominio.Cachorro;
import ZGenereics.Dominio.Gato;

public class B_WildCardTest01 {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();
        imprimeConsulta(cachorro);
        imprimeConsulta(gato);

    }

    private static void imprimeConsulta(Animal animal) {
        animal.consulta();
    }
}
