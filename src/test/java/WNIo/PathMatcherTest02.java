package WNIo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllsFilesJavaAndClass extends SimpleFileVisitor<Path>{
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*ClassMatrixProud*.{java,class}");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (matcher.matches(file)){
            System.out.println(file.getFileName().toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PathMatcherTest02 {
    public static void main(String[] args) {
        Path path1 = Paths.get(".");// "/"
        try {
            Files.walkFileTree(path1, new FindAllsFilesJavaAndClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
