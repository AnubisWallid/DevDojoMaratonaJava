package ZZGConcorrencia;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
    private final Map<String, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock readWriteLock;

    public MapReadWrite(ReentrantReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }
    public void put(String key,String value){
        readWriteLock.writeLock().lock();
        try{
          /* if(readWriteLock.isWriteLocked()) {
                System.out.printf("%s obteve o WRITE LOCK", Thread.currentThread().getName());
            }*/
           map.put(key,value);
           System.out.println(map.get(key));
           Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public Set<String> allKeys(){
        readWriteLock.readLock().lock();
        try{
            return map.keySet();
        }finally{
            readWriteLock.readLock().unlock();
        }
    }
}
public class E_ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);
        Runnable write = () -> {
            System.out.printf("%s: TRYING WRITIENG%n",Thread.currentThread().getName());
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i),String.valueOf(i+10));
            }
        };
        Runnable reader = () -> {
            if (rwl.isWriteLocked()){
                System.out.printf("%s: WRITE LOCKED !%n",Thread.currentThread().getName());
            }
            rwl.readLock().lock();
            System.out.printf("%s: FINALLY I GOT THE DAWN LOCK !%n",Thread.currentThread().getName());
            try{
                System.out.printf("%s: %s%n",Thread.currentThread().getName(),mapReadWrite.allKeys());
            }finally {
                rwl.readLock().unlock();
            }
        };
        Thread t1 = new Thread(write,"T1");
        Thread t2 = new Thread(reader,"T2");
        Thread t3 = new Thread(reader,"T3");
        t1.start();
        t2.start();
        t3.start();

    }
}
