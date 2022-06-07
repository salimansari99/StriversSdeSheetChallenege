import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int mxprofit = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;
        for(int el : prices){
            if(el < buy){
                buy = el;
            }
            else{
                int profit = el - buy;
                mxprofit = Math.max(mxprofit,profit);
            }
        }
        return mxprofit==Integer.MIN_VALUE ? 0 : mxprofit;
    }
}