package ZZGConcorrencia;

import java.util.concurrent.*;

public class L_FutureTest01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(20);
            return 5.20D;
        });
        try {
            System.out.println(doSomething(30));
                Double dollarReponse = dollarRequest.get(3, TimeUnit.SECONDS);
                System.out.println("Dollar: " + dollarReponse);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static long doSomething(int length) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < length; i++) {
            System.out.print((sum += i) + ", ");
            TimeUnit.MILLISECONDS.sleep(200);
        }
        return sum;
    }
}
