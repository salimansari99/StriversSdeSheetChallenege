import java.util.* ;
import java.io.*; 
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
       
        Arrays.sort(arr);
        int lo = 0, hi = arr.length-1;
        //int[][] res = new int[][2];
        ArrayList<int[]> al = new ArrayList<>();
        
        while(lo < hi){
            if(arr[lo]+arr[hi]==s){
                int[] temp = new int[2];
                if(arr[lo]==arr[hi]){
                    for(int i = lo; i < hi; i++){
                        for(int j = i+1; j <= hi; j++){
                            temp[0] = arr[i];
                            temp[1] = arr[j];
                             al.add(temp);
                        }
                    }
                     break;
                }
                int st = lo+1, en = hi-1;
                
                while(st <= en && arr[lo] == arr[st]){
                    st++;
                }
                 while(st <= en && arr[hi] == arr[en]){
                    en--;
                }
                int f1 = st - lo;
                int f2 = hi - en;
                for(int i = 0; i < f1; i++){
                    for(int j = 0; j < f2; j++){
                         temp[0] = arr[i+lo];
                          temp[1] = arr[j+en+1];
                           al.add(temp);
                    }
                }
                lo = st;
                hi = en;
            }
            else if(arr[lo] + arr[hi] > s) hi--;
            else lo++;
        }
        int k = 0;
        int[][] res = new int[al.size()][2];
        
        for(int[] a : al){
            res[k][0] = a[0];
            res[k++][1] = a[1];
        }
        return res;
    }
}