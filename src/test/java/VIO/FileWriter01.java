package VIO;
//File
//FileWriter
//BufferedWriter
//BufferedReader

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter01 {
    public static void main(String[] args) {
        File arquivo = new File("Teste.txt");
        try {
            FileWriter fileWriter = new FileWriter(arquivo,true);
            FileReader fileReader = new FileReader(arquivo);
            fileWriter.write("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");
            fileWriter.write("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");
            fileWriter.write("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");
            fileWriter.flush();
            System.out.println(fileReader.read());



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
