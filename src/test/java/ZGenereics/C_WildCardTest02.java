package ZGenereics;

import ZGenereics.Dominio.Animal;
import ZGenereics.Dominio.Cachorro;
import ZGenereics.Dominio.Gato;

import java.util.List;

public class C_WildCardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato(), new Gato());
        imprimeConsulta(cachorros);
        imprimeConsulta(gatos);
//        imprimeConsulta((List)cachorros);
//        imprimeConsulta((List)gatos);

    }
    private static void imprimeConsulta(List<? extends Animal> animais) { //Qualquer um que seja filho...
        for (Animal animal : animais) {
            animal.consulta();
        }
    }
    private static void imprimeConsultaAnimal(List<? super Animal> animais) { //Qualquer um que pai... Ex.: Object
        for (Object animal : animais) {
            if (animal instanceof Gato) {
                ((Gato) animal).consulta();
            } else {
                ((Cachorro) animal).consulta();
            }
            animais.add(new Gato());
            animais.add(new Cachorro());
        }
    }
//    private static void imprimeConsulta(List<Animal> animais) {
//        for (Animal animal : animais) {
//            animal.consulta();
//        }
//    }
}
