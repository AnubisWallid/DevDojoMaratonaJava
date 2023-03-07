package ZZGConcorrencia;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

final class Anime {
    private final String name;

    public Anime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class F_CopyonWriteTest01 {
    public static void main(String[] args) {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 2000; i++) {
            copyOnWriteArrayList.add(i);
        }
        Runnable runnableIterator = ()->{
            Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnableRemover = () ->{
            for (int i = 0; i < 500; i++) {
                System.out.printf("%s removed %d%n",Thread.currentThread().getName(),
                        copyOnWriteArrayList.remove(i));
            }
        };
        new Thread(runnableIterator).start();
        new Thread(runnableIterator).start();
        new Thread(runnableRemover).start();
    }
}
