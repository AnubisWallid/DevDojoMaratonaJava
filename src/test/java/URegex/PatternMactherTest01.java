package URegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMactherTest01 {
    public static void main(String[] args) {
        //
        String regex = "wallid santana";
        String texto = "wallid santana, jogue duro !!! wallid santana";
        String texto2 = "wallid santana, jogue duro !!! wallid santana";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("text: " + texto);
        System.out.println("Indice: 0123456789");
        System.out.println("regex " + regex);
        while(matcher.find()){
            System.out.print(matcher.start()+" ");
        }
    }
}
