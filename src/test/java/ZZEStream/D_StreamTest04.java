package ZZEStream;

//1. Order LightNovel by title
//2. Retrive the first 3 light novel with price less than 4

import ZZEStream.Dominio.LightNovel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class D_StreamTest04 {
    public static List<LightNovel> lightNovels = new ArrayList<>(
            List.of(
                    new LightNovel("CCC", 1.99),
                    new LightNovel("AAA", 3.99),
                    new LightNovel("BBB", 2.99),
                    new LightNovel("DDD", 5.99),
                    new LightNovel("EEE", 0.99)
            ));

    public static void main(String[] args) {
        List<List<String>> school = new ArrayList<>();
        List<String> professors = List.of(
                "Prof. Manoel",
                "Prof. Jose",
                "Prof. Joao",
                "Prof. Antonio");
        List<String> students = List.of(
                "Luiz",
                "Guilherme",
                "Jonas",
                "Flavio");
        List<String> content = List.of(
                "Math",
                "Language",
                "History",
                "Geograth"
        );
        school.add(professors);
        school.add(students);
        school.add(content);
/**
 for (List<String> strings : school) {
 for (String objects: strings){
 System.out.println(objects);
 }
 }**/
        school.stream().flatMap(Collection::stream).forEach(System.out::println);
    }
}

