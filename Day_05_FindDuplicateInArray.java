import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        //using array as hashmap
        for(int el : arr){
            int x = Math.abs(el);
            if(arr.get(x) > 0) arr.set(x,-arr.get(x));
            else return x;
        }
        return -1;
    }
}
