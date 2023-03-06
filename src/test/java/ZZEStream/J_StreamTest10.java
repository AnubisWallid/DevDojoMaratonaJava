package ZZEStream;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class J_StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1,integer -> integer+1)
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(new int[]{0,1}, i -> new int[]{i[1],i[0] + i[1]})
                .limit(5)
                .forEach(a -> System.out.println(
                        Arrays.toString(a) + " = " + Arrays.stream(a).sum()
                ));
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1,500))
                .limit(50)
                .forEach(System.out::print);
    }
}
