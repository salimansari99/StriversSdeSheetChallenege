import java.util.*;
public class Solution {
    
    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
       ArrayList<Integer> heap = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int[] query : q){
            
          if(query[0] == 0){
             insert(query[1], heap);
          }
            else {
                res.add(remove(heap));
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for(int el : res) ans[i++] = el;
        return ans;
   
    }
    public static void insert(int ele, ArrayList<Integer> heap){
        heap.add(ele);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;
        //up heapify
        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex -1)/2;
            }
            else return;
        }  
    }
    public static int remove(ArrayList<Integer> heap){
        int removed = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()- 1);
        
        //down heapify
        int parentIndex = 0;
        int leftIndex = 2*parentIndex + 1;
        int rightIndex = 2*parentIndex + 2;
        while(leftIndex < heap.size()){
            int minIndex = parentIndex;
            if(heap.get(leftIndex) < heap.get(minIndex))
                minIndex = leftIndex;
            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex))
                minIndex = rightIndex;
            
            if(minIndex == parentIndex) break;
            
            int temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftIndex = 2*parentIndex+1;
            rightIndex = 2*parentIndex+2;
        }
        return removed;
    }
}