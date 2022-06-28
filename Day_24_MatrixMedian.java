import java.util.ArrayList;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		int lo = 1, hi = (int)Math.pow(10,5);
        int n = matrix.size();
        int m = matrix.get(0).size();
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            
            int cnt = 0;
            for(ArrayList<Integer> al : matrix){
                cnt += countOfMid(al,mid);
            }
            
            if(cnt <= (n*m)/2){
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return lo;
	}
    public static int countOfMid(ArrayList<Integer> al, int key){
        int lo = 0, hi = al.size()-1;
        
        while(lo <= hi){
            int mid = lo + (hi -lo)/2;
            if(al.get(mid) <= key) lo = mid + 1;
            else hi = mid -1;
        }
        return lo;
    }
}