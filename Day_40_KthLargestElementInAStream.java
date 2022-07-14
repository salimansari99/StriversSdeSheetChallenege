import java.util.*;
public class Kthlargest {
    PriorityQueue<Integer> pq;
    int k;
    Kthlargest(int k, int[] arr) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int el : arr)
            pq.offer(el);
    }

    void add(int num) {
        pq.offer(num);
        if(pq.size() > k) pq.poll();
        
    }

    int getKthLargest() {
        return pq.peek();
    }
}
