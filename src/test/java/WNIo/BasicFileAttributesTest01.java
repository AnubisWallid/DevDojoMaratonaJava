package WNIo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        //BasicFileAttributes, DoSFileAttributes, PosixFileAttributes
        LocalDateTime date = LocalDateTime.now().minusDays(16L);
        File file = new File("Pasta/novo.txt");
        String isCreated = file.createNewFile()?"SIM":"NAO";
        System.out.println("Criado ? " + isCreated);
        System.out.println("Modificado: ");
        String isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli())?"SIM":"NAO";
        System.out.println("MOdificado ? " + isModified);

        Path path = Paths.get("Pasta/novo.txt");
        Files.createFile(path);
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isExecutable(path));

    }
}
