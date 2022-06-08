import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        
        int i = m-1, j = n-1;
        int ind = m+n-1;
        while(i >= 0 && j >= 0){
            if(arr1[i]>= arr2[j]){
                arr1[ind--] = arr1[i--];
            }
            else{
                arr1[ind--] = arr2[j--];
            }
        }
        while(j >= 0){
            arr1[ind--] = arr2[j--];
        }
        return arr1;
    }
}
