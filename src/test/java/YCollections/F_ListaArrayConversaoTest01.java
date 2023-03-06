package YCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F_ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        Integer[] listToArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listToArray));

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 40;
        numerosArray[1] = 50;
        numerosArray[2] = 60;
        System.out.println("-------------------");
        List<Integer> arrayToList = Arrays.asList(numerosArray); //Os objetos ficam linkados. ver linha 22.
        arrayToList.set(0,123456789);
        //arrayToList.add(17); ERRO !! A lista não pode ser alterada
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);
        System.out.println("-------------------");
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        numerosList.add(17);
        System.out.println(numerosList);




    }
}
