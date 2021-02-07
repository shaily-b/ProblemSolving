package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
Notice that the solution set must not contain duplicate quadruplets.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

 * 
 * **/
public class FourSum {

	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] arr = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(fs.findUniqueQuads(arr, target));

	}
	
public List<List<Integer>> findUniqueQuads(int[] nums, int target) {
        //Sorting the array
        Arrays.sort(nums);
        
        int len = nums.length;
        int left=0,right=0;
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
      
        //Starting 2 loops: first one with 0 th element and second one with next element to it
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
            	//finding the remainder from target after summing the elements from the 2 loop indexes
                int temp_target = target - (nums[i] + nums[j]);
                
                //starting the 2 pointer approach with left as next element to j and right as the end element
                left = j+1;
                right = len-1;
                
                //running loop until both pointers meet
                while(left < right){
                	
                	//incrementing left pointer if sum is less than the temporary target since the array is already sorted
                    if(nums[left]+nums[right] < temp_target){
                        left++;
                        
                    //decrementing right pointer if sum is less than the temporary target since the array is already sorted
                    }else if(nums[left]+nums[right] > temp_target){
                        right--;
                    }else{
                    	
                    	//once we find the sum of left & right indexes equal to temporary target, adding it to result arraylist
                        List<Integer> quad = new ArrayList<Integer>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        result.add(quad);
                        
                        //Now since we don't want to process any duplicates, incrementing left pointer and decrementing right pointer till values change
                        while(left < len && nums[left] == quad.get(2)) left++;
                        
                        while(right > j+1 && nums[right] == quad.get(3)) right--;
                    }
                }
                
                //to avoid any duplicates for jth index
                while(j+1<len && nums[j+1]==nums[j]) j++;
                
            }
            //to avoid any duplicates for ith index
            while(i+1<len && nums[i+1]==nums[i]) i++;
        }
        
        //Returning the resultant list
        return result;
      
    }

}

//Time Complexity : O(N^3)
//Space Complexity : O(1)
