public class Solution 
{
	public static String reverseString(String str) 
	{
		StringBuilder sb = new StringBuilder();
        
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) == ' ') continue;
            
            int j = i;
            while(j >= 0 && (str.charAt(j) != ' ')) j--;
            
            sb.append(str.substring(j+1,i+1));
            sb.append(" ");
            i = j;
        }
        return sb.toString();
	}
}
