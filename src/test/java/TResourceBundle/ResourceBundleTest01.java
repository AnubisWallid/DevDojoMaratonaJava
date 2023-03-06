package TResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        boolean sasa = bundle.containsKey("sasa");
        System.out.println(sasa);
        mensagem(bundle);
        System.out.println();
        bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        mensagem(bundle);
    }

    private static void mensagem(ResourceBundle bundle) {
        System.out.println(bundle.getString("introduction"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("bye"));
    }
}
