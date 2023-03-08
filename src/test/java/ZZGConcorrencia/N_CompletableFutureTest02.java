package ZZGConcorrencia;

import ZZGConcorrencia.Servico.StoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class N_CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService service = new StoreService();
        searchPricesAsyncCompletableFuture(service);
    }

    private static void searchPricesAsyncCompletableFuture(StoreService service) {
        long start = System.currentTimeMillis();
        List<String> stores = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            stores.add(String.format("Store %d", i));
        }
        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(service::getPricesAsyncCompletableFuture)
                .collect(Collectors.toList());
        List<Double> doubles = completableFutures.stream().map(CompletableFuture::join).toList();
        System.out.println(doubles);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
        StoreService.shutdown();
    }
}

