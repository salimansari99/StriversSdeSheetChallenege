import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        Arrays.sort(arr);
        subset(arr,0,ds,res);
        return res;
    }
    public static void subset(int[] arr, int ind, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<Integer>(ds));
        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i-1] ) continue;
                ds.add(arr[i]);
                subset(arr, i+1, ds, res);
                ds.remove(ds.size()-1);
        }
    }
}