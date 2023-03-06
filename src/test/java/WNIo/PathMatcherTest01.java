package WNIo;

import java.nio.file.*;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        matches(path1, path2, path3, "glob:*.bkp");
        matches(path1, path2, path3, "glob:**/*.{bkp,txt,java}");
        matches(path1, path2, path3, "glob:**.???");
        matches(path1, path2, path3, "glob:**/file.???");


    }

    private static void matches(Path path1, Path path2, Path path3, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println("1) " + glob + ": " + matcher.matches(path1));
        System.out.println("2) " + glob + ": " + matcher.matches(path2));
        System.out.println("3) " + glob + ": " + matcher.matches(path3));
        System.out.println("-----------------------");
    }
}
