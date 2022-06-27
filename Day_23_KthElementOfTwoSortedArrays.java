public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        
        int i = 0, j = 0;
        int count = 0;
        
        while(i < m && j < n){
           
            if(row1[i] <= row2[j]){
                count++;
                if(count == k) return row1[i];
                  i++;
            }
            else{
               
                count++;
                if(count == k) return row2[j];
                 j++;
            }
       
        }
        while(i < m){
            count++;
             if(count == k) return row1[i];
            i++;
        }
        while(j < n){
            count++;
            if(count == k) return row2[j];
            j++;
        }
        return -1;
    }
}
