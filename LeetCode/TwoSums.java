package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order. 

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
 * 
 * 
 * 
 * */


public class TwoSums {

	public static void main(String[] args) {

		int[] nums = {1,2,6,9,7,6};
		//int[] nums = {3,2,4};
		int sum = 9;
		int[] result = twoSum(nums,sum);
		System.out.println("["+result[0]+","+result[1]+"]");
		
	}
	
    public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();
       
        for(int i=0;i<nums.length;i++) {
        	hmap.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++) {
        	int complement = target - nums[i];
        	if(hmap.containsKey(complement) && hmap.get(complement) != i) {
        		return new int[] {i,hmap.get(complement)};
        	}
        }
		return null;
                
    }

}
