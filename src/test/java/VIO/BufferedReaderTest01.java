package VIO;

import java.io.*;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
        File arquivo = new File("Teste.txt");
        int i = 10;
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader, 100);
            while (bufferedReader.ready()) {
                System.out.print((char) bufferedReader.read());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
