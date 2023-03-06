package VIO;

import java.io.*;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File arquivo = new File("Teste.txt");
        int i = 10;
        try {
            FileWriter fileWriter = new FileWriter(arquivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while ( i > 0) {
                bufferedWriter.write("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
                bufferedWriter.newLine();
                i--;
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
