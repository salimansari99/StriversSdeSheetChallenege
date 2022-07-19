import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int tr = 0, dr = n-1, lc = 0, rc = m-1;
        int prev = 0, nxt = 0;
        if(n ==1 || m == 1) return;
        while(tr < dr && lc < rc){
            
            int r = mat.get(tr).get(lc);
            int l = mat.get(tr).get(rc);
            int ld = mat.get(dr).get(lc);
            int rd = mat.get(dr).get(rc);
            //top row
            for(int i = rc; i > lc; i--){
                mat.get(tr).set(i,mat.get(tr).get(i-1));
            }
            
            // right col
            for(int i = dr; i > tr+1; i--){
                mat.get(i).set(rc, mat.get(i-1).get(rc));
            }
            mat.get(tr+1).set(rc, l);
            
            // down row
            for(int i = lc; i < rc-1; i++){
                mat.get(dr).set( i, mat.get(dr).get(i+1));
            }
            mat.get(dr).set(rc-1, rd);
            
            // left col
            for(int i = tr; i < dr-1; i++){
                mat.get(i).set(lc, mat.get(i+1).get(lc));
            }
            mat.get(dr-1).set(lc, ld);
            
            lc = lc+1;
            rc = rc-1;
            tr = tr+1;
            dr = dr-1;
            
        }
    }
}
