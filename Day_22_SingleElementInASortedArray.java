import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        int res = 0;
        
        for(int el : arr){
            res ^= el;
        }
        return res;
    }
}