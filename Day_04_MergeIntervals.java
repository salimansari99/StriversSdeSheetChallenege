import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           
            public int compare(Interval p1, Interval p2){
                return p1.start-p2.start;
            }
        });
       List<Interval> res = new ArrayList<>();
        for(Interval el : intervals){
            // non overlapping
            if(res.isEmpty() || res.get(res.size()-1).finish < el.start){
                res.add(el);
            }
            // overlapping
            res.get(res.size()-1).finish = Math.max(el.finish,res.get(res.size()-1).finish);
        }
        return res;
    }
}
