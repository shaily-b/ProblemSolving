package com.practice.gfg;

/*
 * Given a number ‘n’ and our goal is to find out it is palindrome or not without using
any extra space. We can’t make a new copy of number .

Examples:

Input  : 2332
Output : Yes it is Palindrome.
Explanation:
original number = 2332
reversed number = 2332
Both are same hence the number is palindrome.

Input :1111
Output :Yes it is Palindrome.

Input : 1234
Output : No not Palindrome.
 * */

public class NumPallindromeEff {

	public static void main(String[] args) {
		
		NumPallindromeEff np =new NumPallindromeEff();
		
		long n = 1221;
		
		if(np.isPallindrome(n)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		if(np.recursivePallindromeCheck((int) n, 0) == n) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}		

	}
	
	//Efficient method
	public Boolean isPallindrome(long num) {
		
		long divisor = 1;
		
		//finding perfect divisor
		while(num/divisor >= 10) {
			divisor = divisor*10;
		}
		
		while(num !=0 ) {
			
			int leading = (int) (num / divisor);
			int trailing = (int) (num%10);
		
			if(leading != trailing)
				return false;
			
			//removing leading and trailing digits from num
			num = (num % divisor)/10;
			
			//since 2 digits are removed so reducing divisor by 100
			divisor = divisor/100;
			
		}
		
		
		return true;
		
	}
	
	//Recursive Method
	public int recursivePallindromeCheck(int n, int temp) {
		
		if(n == 0) {
			return temp;
		}
		
		temp = (temp*10) + (n % 10) ;
		
		return recursivePallindromeCheck(n/10,temp);
		
	}

}
