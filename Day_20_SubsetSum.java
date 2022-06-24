import java.util.*;
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        subset(0,num,0,res);
        Collections.sort(res);
        return res;
    }
    public static void subset(int ind, int[] num, int sum, ArrayList<Integer> res){
        res.add(sum);
        
        for(int i = ind; i < num.length; i++){
            sum += num[i];
            subset(i+1,num,sum,res);
            sum -= num[i];
        }
    }

}