public class Solution {
    static int V;
    
    static boolean isSafe(int[][] mat, int c, int v, int[] color){
        for(int i=0;i<V;i++)
            if(mat[v][i]==1 && color[i]==c)
                return false;
        return true;
    }
    
    static boolean isGraphUtil(int[][] mat, int v, int m, int[] color){
        if(v==V)
            return true;
        for(int c=1;c<=m;c++){
            if(isSafe(mat, c, v, color)){
                color[v]=c;
                if(isGraphUtil(mat, v+1, m, color))
                    return true;
                color[v]=0;
            }
        }
        return false;
    }
	public static String graphColoring(int[][] mat, int m) {
		V=mat.length;
        int[] color=new int[V];
        if(isGraphUtil(mat, 0, m, color))
            return "YES";
        return "NO";
	}
}
