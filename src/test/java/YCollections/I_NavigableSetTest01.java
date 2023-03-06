package YCollections;

import YCollections.dominio.Smartphone;

import java.util.*;
import java.util.stream.Stream;

class SmartphonePrecoComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}


public class I_NavigableSetTest01 {
    public static void main(String[] args) {
        SmartphonePrecoComparator precoComparator = new SmartphonePrecoComparator();
//        NavigableSet<Smartphone> set = new TreeSet<>();
        NavigableSet<Smartphone> set = new TreeSet<>(precoComparator);
        Smartphone s1 = new Smartphone("001", "Poco", 2000.00, 10);
        Smartphone s2 = new Smartphone("002", "Poco", 1000.00, 10);
        Smartphone s3 = new Smartphone("003", "Poco", 1500.00, 10);
        Smartphone s4 = new Smartphone("004", "Poco", 1500.00, 10);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        for (Smartphone s : set){
            System.out.println(s);
        }
        for (Smartphone s : set.descendingSet()){
            System.out.println(s);
        }
        Smartphone s5 = new Smartphone("002", "Poco", 9000.00, 10);
        //lower -> < o menor
        //floor -> <=
        //higher -> >
        //ceiling -> >=
        System.out.println("---------------------");
        System.out.println("Lower : "+set.lower(s5));
        System.out.println("Floor : "+set.floor(s5));
        System.out.println("Higher : "+set.higher(s5));
        System.out.println("Ceiling : "+set.ceiling(s5));
        System.out.println(set.size());
        System.out.println(set.pollFirst());
        System.out.println(set.size());
        System.out.println(set.pollLast());
        System.out.println(set.size());


    }
}
