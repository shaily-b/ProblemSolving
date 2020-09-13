package com.practice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Given an unsorted array Arr of size N of positive integers. 
 * One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. 
 * Find these two numbers.

Example 1:
Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.


Example 2:
Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
*/

public class MissingAndRepeating {

	    // Driver code
	    public static void main(String[] args) throws Exception {
	        BufferedReader br =
	            new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine().trim());
	        while (t-- > 0) {
	            int n = Integer.parseInt(br.readLine().trim());
	            String[] str = br.readLine().split(" ");

	            int[] a = new int[n];
	            for (int i = 0; i < n; i++) {
	                a[i] = Integer.parseInt(str[i]);
	            }

	            int[] ans = new Solve().findTwoElement(a, n);
	            System.out.println(ans[0] + " " + ans[1]);
	        }
	    }
	}// } Driver Code Ends


	class Solve {
	    int[] findTwoElement(int arr[], int n) {
	        int m=0,r=0;
	        Arrays.sort(arr);
	        for(int i=1;i<n;i++){
	            if(arr[0]!=1){
	                m=1;
	            }else if(arr[i]!=arr[i-1] && arr[i]-arr[i-1]!=1){
	                m = arr[i-1]+1;
	            }
	            
	            if(arr[i]==arr[i-1]){
	                r = arr[i];
	            }
	        }
	        
	        if(m==0){
	            m = n;
	        }
	        
	        return new int[] {r,m};
	    }

}
