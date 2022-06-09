import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        
        //use array as hashmap
        int miss = -1, rep = -1;
        for(int el : arr){
           
            int x = Math.abs(el);
            if(arr.get(x-1)>0) arr.set(x-1,-arr.get(x-1));
            else rep = x;
        }
        
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > 0) miss = i+1;
        }
     
        return new int[]{miss,rep};
    }
}