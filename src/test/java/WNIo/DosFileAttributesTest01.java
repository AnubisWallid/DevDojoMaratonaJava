package WNIo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("Pasta/test.txt");
        if (Files.notExists(path1)) {
            Files.createFile(path1);
            System.out.println("Arquivo: " + path1);
        }

        Files.setAttribute(path1, "dos:hidden", true);
        Files.setAttribute(path1, "dos:readonly", true);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path1, DosFileAttributes.class);
        System.out.println("dosFileAttributes.isHidden(): " + dosFileAttributes.isHidden());
        System.out.println("dosFileAttributes.isReadOnly(): " + dosFileAttributes.isReadOnly());
        System.out.println("dosFileAttributes.isRegularFile(): " + dosFileAttributes.isRegularFile());
        System.out.println("dosFileAttributes.isSystem(): " + dosFileAttributes.isSystem());

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path1, DosFileAttributeView.class);
        fileAttributeView.setHidden(false);
        fileAttributeView.setReadOnly(false);
        fileAttributeView.setSystem(true);
        System.out.println("fileAttributeView.isHidden(): " + fileAttributeView.readAttributes().isHidden());
        System.out.println("fileAttributeView.isReadOnly(): " + fileAttributeView.readAttributes().isReadOnly());
        System.out.println("fileAttributeView.isRegularFile():" + fileAttributeView.readAttributes().isRegularFile());
        System.out.println("fileAttributeView.isSystem(): " + fileAttributeView.readAttributes().isSystem());

    }

}
