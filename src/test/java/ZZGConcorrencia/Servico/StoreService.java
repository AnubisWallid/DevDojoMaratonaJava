package ZZGConcorrencia.Servico;

import java.util.concurrent.*;

public class StoreService {
    private static final ExecutorService exService = Executors.newCachedThreadPool();

    public double getPriceSync(String storeName) {
        System.out.printf("Getting price sync for store: %s%n", storeName);
        return priceGenerator();
    }
    public CompletableFuture<Double> getPricesAsyncCompletableFuture(String storeName) {
        System.out.printf("Getting price sync for store: %s%n", storeName);
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }
    public Future<Double> getPricesAsyncFuture(String storeName) {
        System.out.printf("Getting price sync for store: %s%n", storeName);
        return exService.submit(this::priceGenerator);
    }

    private double priceGenerator() {
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }
    public static void shutdown(){
        exService.shutdown();
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
