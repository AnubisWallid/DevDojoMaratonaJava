package WNIo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("Pasta");
        if(Files.notExists(path1)){
            Path directory1 = Files.createDirectory(path1);
        }
        Path path2 = Paths.get("Pasta\\SubPasta\\SubsubPasta");
        Path subdirectory2 = Files.createDirectories(path2);
        Path filePath = Paths.get(path2.toString(),"file.txt");
        if(Files.notExists(filePath)){
            Path filePathCreated = Files.createFile(filePath);
        }
        Path source = filePath;
        Path target = Paths.get(filePath.getParent().getParent().toString(),"file_renamed.txt");
        Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);
    }
}
