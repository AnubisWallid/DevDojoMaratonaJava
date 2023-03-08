package ZZGConcorrencia;

import ZZGConcorrencia.Servico.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class M_CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService service = new StoreService();
        searchPricesSync(service);
        searchPricesAsync(service);
        searchPricesAsyncCompletableFuture(service);

    }

    private static void searchPricesSync(StoreService service) {
        long start = System.currentTimeMillis();
        System.out.println(service.getPriceSync("Store 1"));
        System.out.println(service.getPriceSync("Store 2"));
        System.out.println(service.getPriceSync("Store 3"));
        System.out.println(service.getPriceSync("Store 4"));
        System.out.println(service.getPriceSync("Store 5"));
        System.out.println(service.getPriceSync("Store 6"));
        System.out.println(service.getPriceSync("Store 7"));
        System.out.println(service.getPriceSync("Store 8"));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }

    private static void searchPricesAsync(StoreService service) {
        long start = System.currentTimeMillis();
        Future<Double> pricesAsyncFuture1 = service.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = service.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = service.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = service.getPricesAsyncFuture("Store 4");
        Future<Double> pricesAsyncFuture5 = service.getPricesAsyncFuture("Store 5");
        Future<Double> pricesAsyncFuture6 = service.getPricesAsyncFuture("Store 6");
        Future<Double> pricesAsyncFuture7 = service.getPricesAsyncFuture("Store 7");
        Future<Double> pricesAsyncFuture8 = service.getPricesAsyncFuture("Store 8");
        try {

            System.out.println(pricesAsyncFuture1.get());
            System.out.println(pricesAsyncFuture2.get());
            System.out.println(pricesAsyncFuture3.get());
            System.out.println(pricesAsyncFuture4.get());
            System.out.println(pricesAsyncFuture5.get());
            System.out.println(pricesAsyncFuture6.get());
            System.out.println(pricesAsyncFuture7.get());
            System.out.println(pricesAsyncFuture8.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
        StoreService.shutdown();
    }
    private static void searchPricesAsyncCompletableFuture(StoreService service) {
        long start = System.currentTimeMillis();
        CompletableFuture<Double> pricesAsyncFuture1 = service.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture2 = service.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture3 = service.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture4 = service.getPricesAsyncCompletableFuture("Store 4");
        CompletableFuture<Double> pricesAsyncFuture5 = service.getPricesAsyncCompletableFuture("Store 5");
        CompletableFuture<Double> pricesAsyncFuture6 = service.getPricesAsyncCompletableFuture("Store 6");
        CompletableFuture<Double> pricesAsyncFuture7 = service.getPricesAsyncCompletableFuture("Store 7");
        CompletableFuture<Double> pricesAsyncFuture8 = service.getPricesAsyncCompletableFuture("Store 8");
        System.out.println(pricesAsyncFuture1.join());
        System.out.println(pricesAsyncFuture2.join());
        System.out.println(pricesAsyncFuture3.join());
        System.out.println(pricesAsyncFuture4.join());
        System.out.println(pricesAsyncFuture5.join());
        System.out.println(pricesAsyncFuture6.join());
        System.out.println(pricesAsyncFuture7.join());
        System.out.println(pricesAsyncFuture8.join());

        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
        StoreService.shutdown();
    }
}

