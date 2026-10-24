import java.util.*;

class Solution 
{

    public int romanToInt(String s) 
    {
       HashMap < Character , Integer> imap = new HashMap<>();
        
        imap.put('I' , 1);
        imap.put('V',  5);
        imap.put('X' , 10);
        imap.put('L' , 50);
        imap.put('C',100);
        imap.put('D',500);
        imap.put('M',1000);

      
        int sum =0;

        for(int i =0;i<s.length();i++)
        {
            int curr = imap.get(s.charAt(i));
            if(i+1<s.length() && curr<imap.get(s.charAt(i+1)))   // IV = 4 k lia 
            {
                sum-=curr;
            }
            else
            {
                sum+=curr;  
            }
        }

        return sum;
    }
}