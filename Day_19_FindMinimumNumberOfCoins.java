public class Solution
{
public static int findMinimumCoins(int amount)
    {
        int cnt = 0;
        
        while(amount > 0){
            if(amount >= 1000){
                amount -= 1000;
                cnt++;
            }
            else if(amount >= 500){
                amount -= 500;
                cnt++;
            }
            else if(amount >= 100){
                amount -= 100;
                cnt++;
            }
             else if(amount >= 50){
                amount -= 50;
                cnt++;
            }
            else if(amount >= 20){
                amount -= 20;
                cnt++;
            }
            else if(amount >= 10){
                amount -= 10;
                cnt++;
            }
             else if(amount >= 5){
                amount -= 5;
                cnt++;
            }
            else if(amount >= 2){
                amount -= 2;
                cnt++;
            }
            else{
                amount -= 1;
                cnt++;
            }
        }
    return cnt;
   
    }
}
