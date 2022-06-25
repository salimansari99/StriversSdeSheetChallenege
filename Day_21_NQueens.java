import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if(n == 1){
            ArrayList<Integer> ds = new ArrayList<>();
            ds.add(1);
            res.add(ds);
            return res;
        }
        if(n == 2 || n == 3) return res;
        int[][] board = new int[n][n];
        queen(n,0,board,res);
        return res;
    }
    public static void queen(int n, int row, int[][] board,ArrayList<ArrayList<Integer>> res){
        if(row == n){
              ArrayList<Integer> ds = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ds.add(board[i][j]);
                }
            }
             res.add(ds);
            return;
        }
        for(int i = 0; i < n; i++){
            if(valid(row,i,board)){
                board[row][i] = 1;
                queen(n,row+1,board,res);
                board[row][i] = 0;
            }
        }
    }
    public static boolean valid(int r, int c, int[][] board){
        
        // vertical
        for(int i = r-1, j = c; i >= 0; i--){
            if(board[i][j] == 1) return false;
        }
        //right diagonal
        for(int i = r-1, j = c+1; i >= 0 && j < board[0].length; i--, j++){
            if(board[i][j] == 1) return false;
        }
        
        //left
        for(int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1) return false;
        }
        return true;
        
    }
}