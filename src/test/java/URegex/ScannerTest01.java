package URegex;

import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Ana, beto, carlos, Danilo, true, 200";
        String[] nomes = texto.split(",");
        for(String nome : nomes){
            System.out.println(nome.trim());
        }

    }
}
