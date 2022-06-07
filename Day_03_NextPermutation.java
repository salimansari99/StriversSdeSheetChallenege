import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{

        int i = permutation.size()-1;
        
        while(i>0 && permutation.get(i)<=permutation.get(i-1)) i--;
        
        i--;
        
        if(i >= 0){
            int j = permutation.size()-1;
            
            while(j >= 0 && permutation.get(i) >= permutation.get(j)) j--;
            swap(permutation,i,j);
         }
        reverse(permutation,i+1);
        return permutation;
	}
    public static void reverse(ArrayList<Integer> permutation, int i){
        int lo = i, hi = permutation.size()-1;
        while(lo<hi){
            swap(permutation,lo,hi);
            lo++;
            hi--;
        }
    }
    public static void swap(ArrayList<Integer> permutation, int i, int j){
            int temp = permutation.get(i);
             permutation.set(i,permutation.get(j) );
             permutation.set(j,temp);
    }
}
