package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 * */

public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int arr[] = {-1,0,1,2,-1,-4};
		List<List<Integer>> res = ts.threeSum(arr);
		System.out.println(res);

	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if(len < 3) return new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        for(int i=0;i<len-2;i++){
            int j = i + 1;
            int k = len - 1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                }else if(sum > 0) k--;
                else if(sum < 0) j++;
            }
        }
        
        return new ArrayList<List<Integer>>(set);
        
    } 

}
