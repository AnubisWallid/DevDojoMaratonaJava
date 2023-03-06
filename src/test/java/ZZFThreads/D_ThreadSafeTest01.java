package ZZFThreads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames {
    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name){
        names.add(name);
    }
    public synchronized void removeFirst(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(names.size());
        if(names.size() > 0){
            System.out.println(names.remove(0));
        }
    }
}
public class D_ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Jaboticaba");
//        threadSafeNames.add("Goiaba");
//        threadSafeNames.add("Maçã");
        Runnable r = threadSafeNames::removeFirst;
        new Thread(r,"T1").start();
        new Thread(r,"T2").start();
    }
}
