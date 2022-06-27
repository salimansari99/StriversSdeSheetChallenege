public class Solution {
    public static double median(int[] a, int[] b) {
    	
        int l1 = a.length, l2 = b.length;
        
        int total = l1 + l2 - 1;
        int k = total / 2;
        int i = 0, j = 0, count = 0;
        double ans = 0.0;
        while(i < l1 && j < l2){
           
            if(a[i] <= b[j]){
                if(count == k){
                    
                    if(total%2 == 0){
                        ans = (double)a[i];
                        return ans;
                    }
                    else{
                        int nxt = 0;
                        if(i+1 < l1){
                        nxt = Math.min(a[i+1],b[j]);
                        
                        }
                        else nxt = b[j];
                         ans = (double)(a[i] + nxt)/(double)2;
                        return ans;
                    }
                }
                i++;
            }
            else{
                 if(count == k){
                    
                    if(total%2 == 0){
                        ans = (double)b[j];
                        return ans;
                    }
                    else{
                        int nxt = 0;
                        if(j+1 < l2){
                            nxt = Math.min(a[i],b[j+1]);
                        }
                        else nxt = a[i];
                         ans = (double)(b[j] + nxt)/(double)2;
                        return ans;
                    }
                }
                j++;
                
            }
             count++;    
        }
        
        while(i < l1 ){
            if(count == k){
                if(total % 2 == 0){
                    return (double) a[i];
                }
                else{
                    int nxt = a[i+1];
                    ans = (double)(a[i] + nxt)/(double)2;
                    return ans;
                }
            } 
            count++;
            i++;
        }
        
        while(j < l2){
            if(count == k){
                if(total % 2 == 0){
                    return (double)b[j];
                }
                else{
                    int nxt = b[j+1];
                    ans = (double)(b[j] + nxt)/(double)2;
                    return ans;
                }
            }
            j++;
            count++;
        }
        return ans;    
    }
}