package com.practice.gfg;

import java.util.Scanner;

/**
 * Given two strings 'str' and a wildcard pattern 'pattern' of length N and M respectively,  You have to print '1' if the wildcard pattern is matched with str else print '0' .

The wildcard pattern can include the characters ‘?’ and ‘*’
‘?’ – matches any single character
‘*’ – Matches any sequence of characters (including the empty sequence)

Example 1:
Input:
pattern = "ba*a?"
str = "baaabab"
Output: 1
Explanation: replace '*' with "aab" and '?' with 'b'. 
 **/

public class WildcardPatternMatching {

	public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				int t = sc.nextInt();
				sc.nextLine();
				while(t>0)
				{
					String pat = sc.nextLine();
					String text = sc.nextLine();
					WildcardPatternMatching w = new WildcardPatternMatching();
					System.out.println(w.wildCard(pat,text));
					t--;
				}
	}
	
	int wildCard(String pattern, String str)
    {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iindex = -1;
        
        while(i<str.length())
        {           
            if(j<pattern.length()&&(pattern.charAt(j)=='?'||pattern.charAt(j)==str.charAt(i)))
            {
                i++;
                j++;
            }
            /*Only incrementing pattern Index when found * in pattern string
              This corresponds to first time since '*' can also represent no characters/empty space*/
            else if(j<pattern.length()&&pattern.charAt(j)=='*')
            {
                starIndex = j; 
                iindex = i; 
                j++; 
            }
            /*This is for replacing * with every character of original string and 
            running loop till pattern matching end to see if it satisfies.
            (Since * can replace 0 or more characters)
            Here we are only incrementing index in original string,
            the pattern string will always start from after the * index */
            else if(starIndex!=-1)
            {
                j = starIndex+1;
                i = iindex+1;
                iindex++;
            }
            else
            { 
                return 0;
            }
        }
        
        /*This is for the case when pattern string > original string 
        and if there are any * at the end of the pattern matching string */
        while(j<pattern.length()&&pattern.charAt(j)=='*')
        {
            j++;
        }
        
        /*Validating if we have covered the entire pattern 
        and hence confirming the string matches the pattern else returning 0 */
        if(j==pattern.length())
        {
            return 1;
        }
        return 0;
    }

}
