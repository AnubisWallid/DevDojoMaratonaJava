package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E_StreamTest05 {
    public static void main(String[] args) {
        List<String> content = List.of(
                "Math",
                "Language",
                "History",
                "Geograth"
        );
        List<String[]> collect = content.stream()
                .map(w -> w.split(""))
                .collect(Collectors.toList());

        List<String> stringStream = content.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(stringStream);

    }
}

