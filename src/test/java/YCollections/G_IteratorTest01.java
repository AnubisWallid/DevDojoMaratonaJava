package YCollections;

import YCollections.dominio.Smartphone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class G_IteratorTest01 {
    public static void main(String[] args) {
        List<Smartphone> smartphones = new LinkedList<>();// o(1) Mais rapido para remover
        smartphones.add(new Smartphone("03", "BBB", 20.0,15));
        smartphones.add(new Smartphone("01", "AAA", 30.0,0));
        smartphones.add(new Smartphone("04", "CCC", 10.0,0));
        smartphones.add(new Smartphone("06", "EEE", 40.0,0));
        smartphones.add(new Smartphone("05", "DDD", 60.0,2));

        for(Smartphone s : smartphones) System.out.println(s);

        Iterator<Smartphone> smartphoneIterator = smartphones.iterator();
        while(smartphoneIterator.hasNext()){
           if(smartphoneIterator.next().getQuantidade() == 0){
               smartphoneIterator.remove();
           };
        }

//        smartphones.removeIf(smartphone -> smartphone.getQuantidade() == 0);
        System.out.println("---------------------");
        for(Smartphone s : smartphones) System.out.println(s);
    }
}
