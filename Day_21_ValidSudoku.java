public class Solution {

	public static boolean isItSudoku(int matrix[][]) {

		return sudoku(matrix);
	}
    public static boolean sudoku(int[][] matrix){
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(matrix[i][j] == 0){
                    // try every possible value
                    for(int k = 1; k <= 9; k++){
                        if(valid(i,j,k,matrix)){
                            matrix[i][j] = k;
                            if(sudoku(matrix)) return true;
                            else matrix[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean valid(int r, int c, int val, int[][] matrix){
        
        for(int i = 0; i < 9; i++){
            if(matrix[r][i] == val) return false;
            
            if(matrix[i][c] == val ) return false;
            
            if(matrix[3*(r/3)+i/3][3*(c/3)+i%3] == val) return false;
        }
        return true;
    }
}
