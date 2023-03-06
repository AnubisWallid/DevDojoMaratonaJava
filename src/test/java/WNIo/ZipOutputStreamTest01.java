package WNIo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("Pasta/arquivo.zip");
        Path arquivoParaZipar  = Paths.get("Pasta/Subpasta1/Subsubpasta1");
        zipper(arquivoZip,arquivoParaZipar);

    }
    private static void zipper(Path arquivoZip, Path arquivosParaZipar){
        try(
            ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
            DirectoryStream<Path> stream = Files.newDirectoryStream(arquivosParaZipar)){
            for(Path p: stream){
                ZipEntry zipEntry = new ZipEntry(p.getFileName().toString());
                zipStream.putNextEntry(zipEntry);
                Files.copy(p,zipStream);
                zipStream.closeEntry();
            }
            System.out.println("Zip criado com SUCESSO.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
