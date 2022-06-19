import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	   Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i < n){
 
            int j = i+1;
            int k = n-1;
            int target = K - arr[i];
            while(j < k){
                if(arr[j] + arr[k] == target){
                    ArrayList<Integer> ds = new ArrayList<>();
                    ds.add(arr[i]);
                    ds.add(arr[j]);
                    ds.add(arr[k]);
                    res.add(ds);
                    int st = j+1;
                    int en = k-1;
                    while(st <= en && arr[j] == arr[st]) st++;
                    while(st <= en && arr[k] == arr[en]) en--;
                    j = st;
                    k = en;
                }
                else if(arr[j]+arr[k] < target) j++;
                else k--;
            }
            while( i < n-1 && arr[i] == arr[i+1]) i++;
            i++;
        }
     return res;
	}
}
