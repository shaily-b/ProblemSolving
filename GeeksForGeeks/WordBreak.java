package com.practice.gfg;

import java.util.ArrayList;

/**
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. 
 * See following examples for more details.

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" or "i like sam sung".
 * */


public class WordBreak {

	public static void main(String[] args) {
		
		WordBreak wb = new WordBreak();
		String dictionary = "i like sam sung samsung mobile ice cream icecream man go mango";
		String word = "idontlike";
		int n = 12;
		wb.isPartOfDictionary(dictionary, word, n);

	}
	
	public void isPartOfDictionary(String dictionary,String word,int len) {
		
		//Add all the words of dictionary string to an ArrayList for easy retrieval and comparison
		ArrayList<String> list = new ArrayList<String>();
		String[] str = dictionary.split(" ");
		for(String s : str) {
			list.add(s);
		}
			
		int i=0,k=0,tempLen=0;
		
		//iterate over the length of input word
			while(i != word.length()+1) {
				
				//get the substring of input word from last index where we found a word of dictionary to the current index
				//initially k will be 0
				String item = word.substring(k, i);
				
				//check if the substring is present in list
				if(!item.isEmpty() && i<len && list.contains(item)){
					
					//if yes, add the length of the substring to tempLen & update k to current index
					tempLen = tempLen + item.length();					
					k=i;
				}
				i++;
			}
		
		//word is fully comprising of dictionary words if its length is equla to tempLen	
		if(tempLen==word.length())
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
