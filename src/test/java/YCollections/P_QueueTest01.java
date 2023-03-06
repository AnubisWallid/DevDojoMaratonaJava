package YCollections;

import java.util.PriorityQueue;
import java.util.Queue;

public class P_QueueTest01 {
    public static void main(String[] args) {
        Queue<String> nomes = new PriorityQueue<>();
        nomes.add("C");
        nomes.add("B");
        nomes.add("D");
        nomes.add("A");
        System.out.println(nomes.poll());
        System.out.println(nomes.poll());
        System.out.println(nomes.poll());
        System.out.println(nomes.poll());
        System.out.println(nomes);
    }
}
