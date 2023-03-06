package ZGenereics;

import ZGenereics.Dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class F_MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> barcoList = criaArray(new Barco("Canoa"));
        barcoList.addAll(criaArray(new Barco("JetSky")));
        barcoList.addAll(criaArray(new Barco("Caravela")));
        System.out.println(barcoList);


    }
//    private static <T extends Comparable<T>> List<T> criaArray(T objeto){
    private static <T> List<T> criaArray(T objeto){
        List<T> lista = new ArrayList<>();
        lista.add(objeto);
        System.out.println("Adicionado: "+objeto);
        return lista;

    }
}