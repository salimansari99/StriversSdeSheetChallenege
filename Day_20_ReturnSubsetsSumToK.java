import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        //Collections.sort(arr);
        subset(arr,0,k,0,ds,res);
        return res;
    }
    public static void subset(ArrayList<Integer> arr, int ind, int target, int sum, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> res){
         if(sum == target){
            res.add(new ArrayList<Integer>(ds));
        }
            for(int i = ind; i < arr.size(); i++){
            ds.add(arr.get(i));
            subset(arr,i+1,target,sum+arr.get(i),ds,res);
            ds.remove(ds.size()-1);
        }
        
    }
}