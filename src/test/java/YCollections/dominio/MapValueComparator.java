package YCollections.dominio;

import java.util.Comparator;
import java.util.Map;

public class MapValueComparator implements Comparator<Map> {

    @Override
    public int compare(Map o1, Map o2) {
        String a = o1.values().toString();
        String b = o2.values().toString();
        return a.compareTo(b) ;
    }
}
