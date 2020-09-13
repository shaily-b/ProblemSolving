package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
*/


public class LongestSubstringNonRepeating {

	public static void main(String[] args) {
		
		LongestSubstringNonRepeating lsr = new LongestSubstringNonRepeating();
		String str = "abcabcbb";
		System.out.println(lsr.lengthOfLongestSubstring(str));

	}
	
	public int lengthOfLongestSubstring(String s){
        int n = s.length();
        Set<Character> hset = new HashSet<Character>();
        
        int i=0,j=0,ans=0;
        
        while(i < n && j < n){
            if(!hset.contains(s.charAt(j))){
                hset.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }else{
                hset.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

}
