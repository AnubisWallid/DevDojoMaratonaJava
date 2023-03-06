package URegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMactherTest02 {
    public static void main(String[] args) {
        //\d => todos os digitos
        //\D => todos os que NÃO forem digitos
        // \s => espaços em branco \t \n \f \r
        // \S => Retira todos os espaços em branco
        // \w => a-z A-Z, digitos, '_'
        // \W => Exclui tudo que não for do \w

        String regex = "wallid santana";
        String regex2 = "\\s";
        String texto = "Wallid santana, jogue duro !!! wallid santana";
        String texto2 = "wa\t23llid\n santa1\f2na21, j\rogue duro3.";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(texto2.toLowerCase());
        System.out.println("text: " + texto2);
        System.out.println("Indice: 0123456789");
        System.out.println("regex " + regex);
        while(matcher.find()){
            System.out.print(matcher.start()+" "+ matcher.group()+"\n");
        }
    }
}
