package URegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMactherTest03 {
    public static void main(String[] args) {
        //\d => todos os digitos
        //\D => todos os que NÃO forem digitos
        // \s => espaços em branco \t \n \f \r
        // \S => Retira todos os espaços em branco
        // \w => a-z A-Z, digitos, '_'
        // \W => Exclui tudo que não for do \w
        //[] - range
        /** Quantificadores:
         *  '?'   => zero ou uma
         *  '*'   => zero ou mais
         *  '+'   => uma ou mais
         *  {n,m} => de n até m
         *  ()    => agrupamento
         *  '|'   => OU, Ex.: lu(l|v)a == lula OU luva
         *  '$'   => final
         *  '.'   => ignora um caracter, Ex.: 1.3 == 123, 1a3, 1 3, 1%3...
         **/
//        String regex = "wallid santana";
//        String regex2 = "[w-zW-Z]";
        String regex2 = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String texto = "Wallid santana, jogue duro !!! wallid santana";
//        String texto2 = "wa\t23llid\n sXxantab1\f2na21, j\roguZe duro3.";
        String texto2 = "12 0x 0X 0xFFABC 0x109 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("text: " + texto2);
        System.out.println("Indice: 0123456789");
        System.out.println("regex " + regex2);
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
