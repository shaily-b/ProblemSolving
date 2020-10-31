package com.practice.leetcode;

import java.util.*;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
 * that the number could represent. Return the answer in any order.
 * 
 * Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

 * */

public class LetterCombinationsOfPhone {

	public static void main(String[] args) {
		LetterCombinationsOfPhone lcp = new LetterCombinationsOfPhone();
		System.out.println(lcp.letterCombinations("23"));

	}

	public List<String> letterCombinations(String digits) {
	      List<String> res = new ArrayList<String>();
	      HashMap<Character,List<String>> hmap = new HashMap<Character,List<String>>();
	        hmap.put('2',Arrays.asList("a","b","c"));
	        hmap.put('3',Arrays.asList("d","e","f"));
	        hmap.put('4',Arrays.asList("g","h","i"));
	        hmap.put('5',Arrays.asList("j","k","l"));
	        hmap.put('6',Arrays.asList("m","n","o"));
	        hmap.put('7',Arrays.asList("p","q","r","s"));
	        hmap.put('8',Arrays.asList("t","u","v"));
	        hmap.put('9',Arrays.asList("w","x","y","z"));
	        
	        char[] ch = digits.toCharArray();
	        int len = digits.length();
	        for(int i=0;i<len;i++){
	            res = prepareOutput(res,hmap.get(ch[i]));
	            }
	        return res;
	    }
	  
	    
	    public List<String> prepareOutput(List<String> res,List<String> curr){
	        List<String> output = new ArrayList<String>();
	        for(String c: curr){
	            if(res.size()>0){
	                for(String r: res){
	                    //System.out.println(r+c);
	                    output.add(r+c);
	                }
	            }else{
	                output.add(c);
	            }
	        }
	        
	        return output;
	    }
}
