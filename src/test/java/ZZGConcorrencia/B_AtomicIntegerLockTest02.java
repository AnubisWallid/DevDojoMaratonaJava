package ZZGConcorrencia;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter2{
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock(true);
    void increment(){
        lock.lock();
        try{
            lock.tryLock(3, TimeUnit.SECONDS);
            count++;
            atomicInteger.getAndIncrement();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}


public class B_AtomicIntegerLockTest02 {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter= new Counter2();
        Runnable r = () -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter.getAtomicInteger());
    }
}
