package com.practice.leetcode;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 * */

public class TrappingWater {

	public static void main(String[] args) {
		
		TrappingWater tw = new TrappingWater();
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = tw.trap(h);
		System.out.println(result);
	}
	
    public int trap(int[] height) {
        if (height.length==0) return 0; 
        int left = 0, right = height.length-1; 
        int leftMax=0, rightMax=0; 
        int ans = 0; 
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left]; 
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]); 
                left++; 
            } else {
                ans += Math.max(0, rightMax-height[right]); 
                right--; 
            }
        }
        return ans; 
    }

}
