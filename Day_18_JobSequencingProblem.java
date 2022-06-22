import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
       List<Pair> al = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++){
            al.add(new Pair(jobs[i][0],jobs[i][1]));
        }
        Collections.sort(al,(p1,p2)->(p1.profit!=p2.profit)?(p2.profit-p1.profit):(p2.deadline-p1.deadline));
        int maxDeadline = al.get(0).deadline;
        for(int i=0;i<jobs.length;i++)
            maxDeadline=Math.max(maxDeadline, al.get(i).deadline);
        
        boolean[] isVisited = new boolean[maxDeadline+1];
        
        int res=0;
        for(int i=0;i<jobs.length;i++){
            for(int j=al.get(i).deadline;j>=1;j--){
                if(!isVisited[j]){
                    isVisited[j]=true;
                    res+=al.get(i).profit;
                    break;
                }
            }
        }
        return res;
    }
}
class Pair{
    int deadline;
    int profit;
    public Pair(int d, int p){
        deadline = d;
        profit = p;
    }
}