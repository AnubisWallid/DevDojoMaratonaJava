package YCollections;
import java.util.LinkedHashMap;
import java.util.Map;

public class K_LinkedHashMapTest01 {
    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>();
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
