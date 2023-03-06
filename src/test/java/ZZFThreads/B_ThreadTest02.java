package ZZFThreads;

public class B_ThreadTest02 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new ThreadExampleRunnable2("Tik "));
        Thread t2 = new Thread(new ThreadExampleRunnable2("Tak "));
        t1.start();
//        t1.join();
        t2.start();
    }

    static class ThreadExampleRunnable2 implements Runnable {
        private String c;

        public ThreadExampleRunnable2(String c) {
            this.c = c;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                System.out.print(c);
            }
//            Thread.yield();
        }
    }
}
