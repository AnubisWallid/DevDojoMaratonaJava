package ZZGConcorrencia;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class G_BlockingQueueTest01 {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        try {
            blockingQueue.put("Nome 1");
            System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), blockingQueue.peek());
            System.out.printf("Trying to add another value...%n");
            new Thread(new RemoveFromQueue(blockingQueue)).start();
            blockingQueue.put("Nome 2");
            System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), blockingQueue.peek());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    static class RemoveFromQueue implements Runnable {
        private final BlockingQueue<String> blockingQueue;

        public RemoveFromQueue(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }


        @Override
        public void run() {
            System.out.printf("%s going to sleep for 2 secs...%n", Thread.currentThread().getName());
            try {
                System.out.printf("%s removing value from queue %s%n", Thread.currentThread().getName(), blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
