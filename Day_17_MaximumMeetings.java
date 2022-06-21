import java.util.*;
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {             int n = start.length;
        ArrayList<Pair> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            al.add(new Pair(start[i],end[i],i+1));
        }   
         Collections.sort(al,new MeetComparator());                                                                
         List<Integer> res = new ArrayList<>();
            res.add(al.get(0).pos);                                                             
         int limit = al.get(0).end;
        for(int i = 1; i < n; i++){
            if(al.get(i).st > limit){
                res.add(al.get(i).pos);
                limit = al.get(i).end;
            }
        }                                                                 
      return res;                                                             
    }
}
class MeetComparator implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p1.end - p2.end;
    }
}
class Pair{
        int st;
        int end;
        int pos;
        public Pair(int st, int end,int pos){
            this.st = st;
            this.end = end;
            this.pos = pos;
        }
    }