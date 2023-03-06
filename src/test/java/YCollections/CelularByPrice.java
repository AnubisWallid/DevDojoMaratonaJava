package YCollections;

import YCollections.dominio.Smartphone;

import java.util.Comparator;
import java.util.List;

public class CelularByPrice implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
