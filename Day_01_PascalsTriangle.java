import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
         List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = null, ds;
        for(int i = 0; i < numRows; i++){
            ds = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j==0 || j==i) ds.add(1);
                else ds.add(pre.get(j-1)+pre.get(j));
            }
            res.add(ds);
            pre = ds;
        }
        return res;
	}
}
