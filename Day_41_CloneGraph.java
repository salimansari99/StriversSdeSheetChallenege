/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/
import java.util.*;
public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        
        Map<graphNode, graphNode> map = new HashMap<>();
        
        graphNode newNode = new graphNode(node.data);
        map.put(node, newNode);
        
        Queue<graphNode> q = new LinkedList<>();
        
        while(!q.isEmpty()){
            
            int n = q.size();
            for(int i = 0; i < n; i++){
                graphNode front = q.poll();
                for(graphNode child : front.neighbours){
                    if(!map.containsKey(child)){
                       graphNode newChild = new graphNode(child.data); 
                       map.put(child, newChild);
                        q.add(child);
                    }
                    graphNode list = map.get(front);
                    list.neighbours.add(map.get(child));
                }
                
            }
        }
        return map.get(node);
        
    }
}