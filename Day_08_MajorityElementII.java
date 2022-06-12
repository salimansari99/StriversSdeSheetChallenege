import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
       
        int cand1 = -1, cand2 = -1;
        int cnt1 = 0, cnt2 = 0;
        int i = 0, n = arr.size();
        int k = (int)Math.floor(n/3);
        while(i < arr.size()){
             if(cand1 == arr.get(i)) cnt1++;
               else if(cand2 == arr.get(i)) cnt2++;
            else if(cnt1 == 0){
                cand1 = arr.get(i);
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                cand2 = arr.get(i);
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
            i++;
        }
        int k1 = 0, k2 = 0;
        for(int el : arr){
            if(el==cand1) k1++;
            else if(el==cand2) k2++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(k1 > k) res.add(cand1);
        if(k2 > k) res.add(cand2);
        return res;
        
    }
}