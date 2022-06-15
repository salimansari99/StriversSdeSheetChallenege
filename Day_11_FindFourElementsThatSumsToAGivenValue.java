import java.util.* ;
import java.io.*; 
public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      
      // brute force
      /*
      for(int i = 0; i < n; i++){
          for(int j = i+1; j < n; j++){
              for(int k = j+1; k < n; k++){
                  for(int l = k+1; l < n; l++){
                      if(arr[i]+arr[j]+arr[k]+arr[l] == target) return "Yes";
                  }
              }
          }
      }
      return "No";
      */
      
      
      Arrays.sort(arr);
      int i = 0;
      while(i < n){
          int j = i+1;
          while(j < n){
              int lo = j+1;
              int hi = n-1;
              int sum = target - (arr[i] + arr[j]);
              while(lo < hi){
                  if(arr[lo]+arr[hi] == sum) return "Yes";
                   else if(arr[lo]+arr[hi] < sum) lo++;
                     else hi--;
              }
              //same element
              while(j+1 < n && arr[j] == arr[j+1]) j++;
              j++;
          }
          while(i+1 < n && arr[i]==arr[i+1]) i++;
          i++;
      }
      return "No";
      
  }
}
