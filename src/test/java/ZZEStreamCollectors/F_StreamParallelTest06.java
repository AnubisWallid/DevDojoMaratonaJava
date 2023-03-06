package ZZEStreamCollectors;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class F_StreamParallelTest06 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 10_000_000;
        sumFor(num);
        sumStreamInterate(num);
        sumParralelStreamInterate(num);
        sumLongStreamInterate(num);
        sumParralelLongStreamInterate(num);
        /**
         * Parralel Stream
         *
         * Considerar:
         *  - Benchmark
         *  - Unboxing | boxing (Wraper)
         * ruins (limit, findFirst)
         * bom (FindAny)
         * Custo Total da computação N, P
         * Quantiaade de dados
         * Tipos de Coleções
         * Tamanho do Stream (Tamanho definido)
         * Processamento do Merge
         * **/
    }

    private static void sumFor(long num) {
        System.out.println("Sum For");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        print(init, result, end);
    }

    private static void sumStreamInterate(long num) {
        System.out.println("Sum StreamInterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        print(init, result, end);
    }

    private static void sumParralelStreamInterate(long num) {
        System.out.println("Sum ParralelStreamInterate");
        long init = System.currentTimeMillis();
        long result = Stream.iterate(1L, i -> i + 1)
                .limit(num)
                .parallel()
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        print(init, result, end);
    }

    private static void sumLongStreamInterate(long num) {
        System.out.println("Sum LongStreamInterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        print(init, result, end);
    }

    private static void sumParralelLongStreamInterate(long num) {
        System.out.println("Sum ParralelLongStreamInterate");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L, num)
                .parallel()
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        print(init, result, end);
    }

    private static void print(long init, long result, long end) {
        System.out.println(result + " " + (end - init) + ", millisecunds");
    }
}
