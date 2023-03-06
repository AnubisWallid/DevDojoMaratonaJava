package YCollections;

import YCollections.dominio.MapValueComparator;

import java.util.HashMap;
import java.util.Map;

public class J_MapTest01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","Um");
        map.put("2","Dois");
        map.put("3","Tres");
        map.put("4","Quatro");
        for(String n: map.keySet()){
            System.out.println(n +": "+map.get(n));
        }
        System.out.println("-----------------------");
        for(Map.Entry<String,String> n: map.entrySet()){
            System.out.println(n);
            System.out.println(n.getKey()+" : "+n.getValue());
        }
    }
}
