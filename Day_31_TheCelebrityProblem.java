/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        int first = 0;
        for(int i =1; i < n; i++){
           if(Runner.knows(0,i)) first++; 
        }
    
        for(int i = 1; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(Runner.knows(i,j) && i != j){
                    cnt++;
                }
            }
             if(first == 0 && cnt == 0) return -1;
              else if(cnt == 0) return i;
        }
        return first == 0 ? 0 : -1;
    }
}