package YCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E_BinarySearchTest02 {
    public static void main(String[] args) {
        List<String> numeros1 = new ArrayList<>(4);
        numeros1.add("E");
        numeros1.add("F");
        numeros1.add("D");
        numeros1.add("A");
        numeros1.add("C");
        Collections.sort(numeros1);
        //(-(ponto de inserção) -1)
        //Indice: 0 1 2 3 4 5 6 7
        //valor:  A B C D E F G H
        System.out.println("Indice: "+Collections.binarySearch(numeros1,"B"));
//        Collections.binarySearch();
    }
}
