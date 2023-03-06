package URegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMactherTest04 {
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
        String regex2 = "([0-9a-zA-Z\\._-])+@([a-zA-Z0-9])+.([a-z]|.[a-z])+";
//        String texto = "Wallid santana, jogue duro !!! wallid santana";
//        String texto2 = "wa\t23llid\n sXxantab1\f2na21, j\roguZe duro3.";
        String texto2 = "1example@servidor.com, " +
                "2exampl23e@servidor.com.br, " +
                "3examp_23le@gservidor.com.br, " +
                "4examp_2qv3le@GGser_vidor.com.br, " +
                "5examp_23le@sedrvidor.com.br, " +
                "6examp_23le @servidor.com.br, " +
                "7examp_23leGGservidor.com.br, " +
                "8example@servidor424.com.br";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("text: " + texto2);
        System.out.println("Indice: 0123456789");
        System.out.println("regex " + regex2);
        while (matcher.find()) {
            System.out.print(matcher.start() + ": " + matcher.group() + "\n");
        }
        System.out.println("7examp_23leGGservidor.com.br".matches(regex2));
    }
}
