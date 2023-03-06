package ZZFThreads;

public class E_ThreadDeadLockTest01 {
    public static void main(String[] args) {


        Object obj1 = new Object();
        Object obj2 = new Object();

        Runnable r1 = () -> {
            synchronized (obj1) {
                System.out.println("Thread 1: Segundando Objeto 1");
                System.out.println("Thread 1: Esperando Objeto 2");
                synchronized (obj2) {
                    System.out.println("Thread 1: Segurando Objeto 2");

                }
            }
        };
        Runnable r2 = () -> {
            synchronized (obj2) {
                System.out.println("Thread 2: Segundando Objeto 2");
                System.out.println("Thread 2: Esperando Objeto 1");
                synchronized (obj1) {
                    System.out.println("Thread 2: Segurando Objeto 1");

                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}

