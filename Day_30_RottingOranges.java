import java.util.*;
public class Solution {

	public static int minTimeToRot(int[][] grid, int n, int m) {
		
        int time = 0, totalOrange = 0, rotten = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if( grid[i][j] == 1 || grid[i][j] == 2 )
                    totalOrange++;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                }
            }
        if(totalOrange == 0) return 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            
            int size = q.size();
            rotten += size;
            
            if(rotten == totalOrange) return time;
            time++;
            
            while(size-->0){
                int[] arr = q.poll();
                for(int[] dir : dirs){
                    int r = arr[0] + dir[0];
                    int c = arr[1] + dir[1];
                    if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                    }
                }
            }
        }
        return -1;
    }
}