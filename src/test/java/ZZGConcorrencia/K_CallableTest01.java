package ZZGConcorrencia;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
//        Math.random();
        int number = ThreadLocalRandom.current().nextInt(1, 20);
        for (int i = 0; i < number; i++) {
            System.out.printf("%s executando uma tarefa Callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s finalizou e o numero aleatorio foi: %d%n", Thread.currentThread().getName(), number);
    }
}

public class K_CallableTest01 {
    public static void main(String[] args) {
        RandomNumberCallable numberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> stringFuture = executorService.submit(numberCallable);
        try {
            System.out.println(stringFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Programa Finalizado");
        executorService.shutdown();
    }
}
