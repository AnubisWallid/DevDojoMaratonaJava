package ZZGConcorrencia;

import ZZGConcorrencia.Dominio.Quote;
import ZZGConcorrencia.Servico.StoreServiceWithDiscount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Q_CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);

    }


    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4","Store 5","Store 6");
        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::setAttributes))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                /*.forEach(store ->{System.out.printf("%s finished in %d%n",store, (System.currentTimeMillis() - start));});*/
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures);
        voidCompletableFuture.join();
        System.out.printf("Finished ? %b%n",voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }
}

