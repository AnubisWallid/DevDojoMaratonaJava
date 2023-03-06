package VIO;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio = new File("Pasta");
        System.out.println("Diretorio 'Pasta' Criado? "+(fileDiretorio.mkdir()?"SIM":"NAO"));
        File fileArquivoDiretorio = new File("Pasta\\arquivo.txt");
        System.out.println("Arquivo 'arquivo.txt' Criado? "+(fileArquivoDiretorio.createNewFile()?"SIM":"NAO"));
        File filerename = new File(fileDiretorio,"arquivo_renomeado.txt");
        System.out.println("Arquivo 'arquivo.txt' renomeado? "+(fileArquivoDiretorio.renameTo(filerename)?"SIM":"NAO"));

        File diretorioRenamed = new File("Pasta_renomeado");
        System.out.println("Diretorio 'Pasta' renomeado? "+((fileDiretorio.renameTo(diretorioRenamed))?"SIM":"NAO"));
    }
}
