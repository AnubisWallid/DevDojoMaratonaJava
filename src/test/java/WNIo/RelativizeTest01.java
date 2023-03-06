package WNIo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) throws IOException {
        Path diretorio1 = Paths.get("/Pasta/SubPasta");
        Path diretorio2 = Paths.get("/Pasta/SubPasta/SubsubPasta/file_renamed.txt");
        Path resolve = diretorio1.resolve(diretorio2);
        System.out.println(resolve);
        System.out.println("Arquivo existe? " + Files.exists(resolve));

        Path absoluto = Paths.get("/Pasta/SubPasta");
        Path relativo = Paths.get("SubsubPasta");
        Path arquivo = Paths.get("arquivo.txt");

        System.out.println("1 " + absoluto.resolve(relativo));// 1 \Pasta\SubPasta\SubsubPasta
        System.out.println("2 " + absoluto.resolve(arquivo));// 2 \Pasta\SubPasta\arquivo.txt
        System.out.println("3 " + relativo.resolve(absoluto));// 3 \Pasta\SubPasta
        System.out.println("4 " + relativo.resolve(arquivo));// 4 SubsubPasta\arquivo.txt
        System.out.println("5 " + arquivo.resolve(absoluto));// 5 \Pasta\SubPasta
        System.out.println("6 " + arquivo.resolve(relativo));// 6 arquivo.txt\SubsubPasta
    }
}
