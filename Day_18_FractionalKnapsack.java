/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

import java.util.*;
public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
        List<Node> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            double rate = (double)items[i].value/(double)items[i].weight;
            al.add(new Node(items[i].weight, items[i].value ,rate));
        }
        Collections.sort(al,new NodeComparator());
        double res = 0;
        for(int i = 0; i < n; i++){
            if(w - al.get(i).weight >= 0){
                res += al.get(i).val;
                w = w - al.get(i).weight;
            }
            else{
                res += w*(al.get(i).rate);
                break;
            }
        }
        return res;
    }
}
class Node{
    int weight;
    int val;
    double rate;
    public Node(int weight, int val, double rate){
        this.weight = weight;
        this.val = val;
        this.rate = rate;
    }
}
class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node n1,Node n2){
        if(n1.rate < n2.rate) return 1;
        else if(n1.rate > n2.rate) return -1;
        else return 0;
    }
}
