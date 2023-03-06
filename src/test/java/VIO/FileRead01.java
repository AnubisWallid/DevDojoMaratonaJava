package VIO;
//File
//FileWriter
//BufferedWriter
//BufferedReader

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead01 {
    public static void main(String[] args) {
        File arquivo = new File("Teste.txt");
        String texto ="";
        try {
            FileReader fileReader = new FileReader(arquivo);
            while (fileReader.ready()) {
                texto = texto.concat(Character.toString(fileReader.read()));
            }
            System.out.println(texto);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
