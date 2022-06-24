import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(arr);
         subset(arr,0,target,new ArrayList<Integer>(),res);
        return res;
    }
    public static void subset(ArrayList<Integer> arr, int ind, int target, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
        if(target < 0) return;
        else if(target == 0){
            res.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i = ind; i < arr.size(); i++){
            if(i > ind && arr.get(i) == arr.get(i-1)) continue;
            ds.add(arr.get(i));
            subset(arr,i+1,target-arr.get(i),ds,res);
            ds.remove(ds.size()-1);
        }
    }
}