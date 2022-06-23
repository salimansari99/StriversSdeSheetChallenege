import java.util.*;
public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        List<Node> al = new ArrayList<>();
        for(int i = 0; i < start.size(); i++){
            al.add(new Node(start.get(i),end.get(i)));
        }
        Collections.sort(al,new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.end != n2.end) return n1.end - n2.end;
                return n1.st - n2.st;
            }
        });
        
        int cnt = 1;
        int limit = al.get(0).end;
        for(int i = 1; i < start.size(); i++){
            if(al.get(i).st >= limit){
                limit = al.get(i).end;
                cnt++;
            }
        }
        return cnt;
    }
}
class Node{
    int st;
    int end;
    public Node(int st, int end){
        this.st = st;
        this.end = end;
    }
}