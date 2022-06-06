import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        //national dutch flag algorithm
        
        int lo = 0, mid = 0, hi = arr.length-1;
        
        while(mid<=hi){
            
            switch(arr[mid]){
                case 0 : {
                    int temp = arr[mid];
                    arr[mid] = arr[lo];
                    arr[lo] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1 :{
                    mid++;
                    break;
                }
                case 2:{
                    int temp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = temp;
                    hi--;
                    break;
                }
                    
            }
            
        }
    }
}