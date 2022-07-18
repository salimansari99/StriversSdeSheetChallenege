public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        
        return knapsack(arr, 0, n, target);
    }
    public static boolean knapsack(String[] arr, int i, int n, String target){
        if(i == n && target.length() == 0) return true;
        if(i == n && target.length() > 0) return false;
        if(i <= n && target.length() == 0) return true;
        
        int s = arr[i].length();
        int t = target.length();
        if(s <= t && arr[i].equals(target.substring(0,s))){
            return knapsack(arr, 0, n, target.substring(s, t));
        }
        else return knapsack(arr, i+1, n, target);
    }
}