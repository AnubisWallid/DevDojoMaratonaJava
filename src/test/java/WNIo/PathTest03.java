package WNIo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest03 {
    public static void main(String[] args) {
        Path path1 = Paths.get("Pasta/SubPasta");
        Path path2 = Paths.get("SubsubPasta/file_renamed.txt");
        Path resolve = path1.resolve(path2);
        System.out.println(Files.exists(path1));
        System.out.println(Files.exists(path2));
        System.out.println(Files.exists(resolve));

        //Caminho Absoluto VS Relativo
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
