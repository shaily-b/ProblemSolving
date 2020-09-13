package com.practice.leetcode;

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
 * 
 * */

public class LongestPallindromicSubstring {

	public static void main(String[] args) {
		LongestPallindromicSubstring lps = new LongestPallindromicSubstring();
		String str = "babad";
		System.out.println(lps.longestPalindrome(str));

	}
	
public String longestPalindrome(String s) {
        
        if(s.length()==0)
            return "";
        
        int start=0,end=0;
        
        for(int i=0;i<s.length()-1;i++){
            //check for odd length pallindrome around i
            int len1 = expandAroundCenter(s,i,i);
            
            //check for even length pallindrome around i
            int len2 = expandAroundCenter(s,i,i+1);
            
            int len = Math.max(len1,len2);
            
            //keeping track of maximum length among all pallindromes
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }         
        }
        
        return s.substring(start,end+1); 
        
    }
    
    public int expandAroundCenter(String str, int left, int right){
        int l =left, r = right;
        while(l>=0 && r< str.length() && str.charAt(l) == str.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

}
