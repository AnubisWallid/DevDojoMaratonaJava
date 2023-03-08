package ZZGConcorrencia;

import ZZGConcorrencia.Servico.StoreServiceDeprecated;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class O_CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated service = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFuture(service);
    }

    private static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated service) {
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        List<String> stores = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            stores.add(String.format("Store %d", i));
        }

        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(
                        () -> service.getPriceSync(s), executor
                )).toList();

        List<Double> collect = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println(collect);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
        executor.shutdown();
    }
}

