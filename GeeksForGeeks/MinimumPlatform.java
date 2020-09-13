package com.practice.gfg;

import java.util.Scanner;

/*
 * Given arrival and departure times of all trains that reach a railway station. 
 * Your task is to find the minimum number of platforms required for the railway station 
 * so that no train waits.
 * 
 * Input:
The first line of input contains T, the number of test cases. For each test case, 
first line will contain an integer N, the number of trains. Next two lines will consist of 
N space separated time intervals denoting arrival and departure times respectively.
Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , 
where the first two charcters represent hour (between 00 to 23 ) and last two characters represent 
minutes (between 00 to 59).

Output:
For each test case, print the minimum number of platforms required for the trains to arrive 
and depart safely.

Example:
Input:
2
6 
0900  0940 0950  1100 1500 1800
0910 1200 1120 1130 1900 2000
3
0900 1100 1235
1000 1200 1240 

Output:
3
1

 * */

public class MinimumPlatform {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0){
		    int len = scan.nextInt();
		    int arr[] = new int[len];
		    int dep[] = new int[len];
		    for(int i=0;i<len;i++){
		        arr[i]=scan.nextInt();
		    }
		    for(int i=0;i<len;i++){
		        dep[i]=scan.nextInt();
		    }
		    int i=0,j=0,res=1;
		    while(i < len-1 && j < len-1){
		        if(arr[i]<dep[j] && dep[j]<arr[i+1]){
		            i++;
		            j++;
		        }else if(dep[j]>arr[i+1]){
		            res++;
		            i++;
		        }else{
		            i++;
		            j++;
		        }
		    }
		    System.out.println(res);
		}

	}

}
