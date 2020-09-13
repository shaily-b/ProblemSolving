package com.practice.gfg;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * The cost of stock on each day is given in an array A[] of size N. 
 * Find all the days on which you buy and sell the stock so that in between those days 
 * your profit is maximum.
 * 
 * Example
Input:
3
7
100 180 260 310 40 535 695
4
100 50 30 20
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
No Profit
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
 * */

public class StockBuySell {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-- > 0){
		    int n = scan.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=scan.nextInt();
		    }
		    int i=0;
		    ArrayList<Integer> al = new ArrayList<Integer>();
		    while(i<n-1){
		    
		        if(arr[i]<arr[i+1]){
		            al.add(i);
		            i++;
		            while(i<n-1 && arr[i]<arr[i+1]){
		                i++;
		            }
		            al.add(i);
		        }
		        i++;
		    }
		    if(al.size()==0){
		        System.out.print("No Profit");
		    }else{
		    for(int j=0;j<al.size()-1;j=j+2){
		        System.out.print("("+al.get(j)+" "+al.get(j+1)+") ");
		    }
		    }
		    System.out.println();
		}
		
		}


}
