import java.util.* ;
import java.io.*; 
public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        /* Recursive
        if(n==0) return 1;
        if(n==1) return x%m;
        if(n%2==0) return modularExponentiation(x*x,n/2,m)%m;
        else return x*(modularExponentiation(x,n-1,m)) % m;
        */
        long res = 1, num = x;
        while(n > 0){
            if(n % 2 == 0){
                num = ((num%m) * (num%m))%m;
                n = n>>1;
            }
            else{
                res = (res*(num%m))%m;
                n--;
            }
        }
        return (int)(res%m);
    }
}