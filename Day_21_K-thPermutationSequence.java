import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        int mul=1;
        ArrayList<Integer> num=new ArrayList();
        for(int i=1;i<n;i++){
            mul*=i;
            num.add(i);
        }
        num.add(n);
        k--;
        String res="";
        while(true){
            int pos=(k/mul);
            res+=num.get(pos);
            num.remove(pos);
            k%=mul;
            if(num.size()==0) break;
            mul/=num.size();
        }
        return res;
    }
}