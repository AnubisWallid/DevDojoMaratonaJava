package VIO;

import java.io.File;
import java.io.IOException;

public class Filetest01 {
    public static void main(String[] args) {
        File arquivo = new File("file.txt");
        try {
            System.out.println("O arquivo existe ? " + ((arquivo.exists())?"Sim":"Nao"));
            String isCreated = (arquivo.createNewFile())? "Sim":"Nao";
            System.out.println("Criado ? " + isCreated);
            System.out.println("Path: " + arquivo.getPath());
            System.out.println("Path Absolute: " + arquivo.getAbsolutePath());
            System.out.println("Path Canonical: " + arquivo.getCanonicalPath());
            System.out.println("Is Directory: " + ((arquivo.isDirectory())? "Sim":"Nao"));
            System.out.println("Is File: " + ((arquivo.isFile())? "Sim":"Nao"));
            System.out.println("Last Modified: " + arquivo.lastModified());
            Thread.sleep(5000);
            System.out.println("O arquivo existe ? " + ((arquivo.exists())?"Sim":"Nao"));
            System.out.println("Deletado ? " + ((arquivo.delete())? "Sim":"Nao"));
            System.out.println("O arquivo existe ? " + ((arquivo.exists())?"Sim":"Nao"));

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
