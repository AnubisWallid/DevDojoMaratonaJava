package URegex;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        String texto = "Ana,beto,carlos,Danilo,true,200";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int inteiro = scanner.nextInt();
                System.out.println("Int: " + inteiro);
            } else if (scanner.hasNextBoolean()) {
                Boolean vOuF = scanner.nextBoolean();
                System.out.println("Boolean: " + vOuF);
            } else {
                System.out.println(scanner.next());
            }
        }

    }
}
