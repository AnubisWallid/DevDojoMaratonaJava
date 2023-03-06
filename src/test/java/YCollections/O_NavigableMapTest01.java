package YCollections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class O_NavigableMapTest01 {
    public static void main(String[] args) {
//        NavigableSet<Smartphone> set = new TreeSet<>();
        NavigableMap<Integer,String> smartNavMap = new TreeMap<>();
        smartNavMap.put(1,"First");
        smartNavMap.put(2,"Secund");
        smartNavMap.put(3,"Third");
        smartNavMap.put(4,"Fourth");
        smartNavMap.put(5,"Fifth");
        for(Map.Entry<Integer,String> entry : smartNavMap.entrySet()){
            System.out.println(entry.getKey() + " : "+entry.getValue());
        }
        System.out.println(smartNavMap.headMap(3,true));//{3=Third, 2=Secund, 1=First}

    }
}
