package ZZGConcorrencia;

/*import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;*/

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class H_LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
//        ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
//        Junção das 3 em LinkedTransferQueue
        TransferQueue<Object> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Wallid"));//lança exception
        System.out.println(tq.offer("Wallid"));
        System.out.println(tq.offer("Wallid", 10, TimeUnit.SECONDS));
        tq.put("Santana");
        if (tq.hasWaitingConsumer()) {
            tq.transfer("Santana");
        }
        System.out.println(tq.tryTransfer("Santana"));
        System.out.println(tq.tryTransfer("Santana",5,TimeUnit.SECONDS));
        System.out.println(tq.element());//olha quem está no topo, sem remover
        System.out.println(tq.peek());//pega mas não remove, retorna empty se vazia
        System.out.println(tq.poll());//pega e remove, retorna null se vazia
        System.out.println(tq.remove());//pega e remove, lança exception se vazia
        System.out.println(tq.take());// pega e e espera se estiver vazia
        System.out.println(tq.remainingCapacity());
    }
}
