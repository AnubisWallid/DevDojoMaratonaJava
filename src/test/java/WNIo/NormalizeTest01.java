package WNIo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioProjeto = "Pasta/SubPasta/SubsubPasta";
        String arquivoRecebido = "../../file.txt";
        Path path1 = Paths.get(diretorioProjeto, arquivoRecebido);
        System.out.println(path1);
        System.out.println(path1.normalize());
        System.out.println(Files.exists(path1));


    }
}
