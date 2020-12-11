package com.practice.gfg;

/*
 * Given two numbers as strings. The numbers may be very large (may not fit in long long int), 
 * the task is to find difference of these two numbers.

Examples:  

Input : str1 = "11443333311111111100", 
        str2 =     "1144422222221111"
Output : 11442188888888889989

Input :str1 = "122387876566565674",
       str2 =     "31435454654554"
Output : 122356441111911120
 
 * */
public class DifferenceOfBigNumbers {

	public static void main(String[] args) {
		DifferenceOfBigNumbers dobn = new DifferenceOfBigNumbers();
		
		//Taking input number as string since numbers are very large
		String n1 ="11443333311111111100";
		String n2 = "1144422222221111";

		//Finding the greater and smaller numbers among the 2 given strings
		String greater = dobn.findGreaterNumber(n1,n2);
		//System.out.println(greater);
		String smaller = greater.equals(n1) ? n2 : n1;
		
		String result = dobn.findDifference(greater,smaller);
		System.out.println("Difference is : "+result);
	}

	private String findGreaterNumber(String n1, String n2) {
		int l1 = n1.length();
		int l2 = n2.length();
		
		//first comparing the length, 
		//if length of a string is greater then returning that string as greater number
		if(l1 > l2)
			return n1;
		else if(l1 < l2)
			return n2;
		else {
			//when length of both string is same then comparing each digit of string to get greater number
			for(int i=0;i<l1;i++) {
			 if(Integer.parseInt(n1.substring(i, i+1)) != Integer.parseInt(n2.substring(i, i+1))) {
				if(Integer.parseInt(n1.substring(i, i+1))> Integer.parseInt(n2.substring(i, i+1))) {
					return n1;
				}else {
					return n2;
				}
			  } 
			}
		}
		
		return null;
	}
	
	//This method parses string from end and does the subtraction digit wise
	private String findDifference(String greater, String smaller) {
		int g = greater.length();
		int s = smaller.length();
		
		//converting to char array for easy access of digits
		char[] gc = greater.toCharArray();
		char[] sc = smaller.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		//traversing the strings from end
		for(int i=g-1,j=s-1;i>=0;i--,j--) {
			int gi = Character.getNumericValue(gc[i]);
			
			//condition to check if length of smaller string is still valid
			if(j>=0) {
			int si = Character.getNumericValue(sc[j]);
			if( gi >= si ) {
				//when difference is postive or 0, simply appending to result string
				sb.append(gi-si);
			}else {
				//otherwise adding 10 to the difference 
				//which is equivalent of taking carry from previous digit
				sb.append(10 + gi - si);
				
				//if previous digit of greater string is 0, replacing it with 9 until a non-zero digit is found
					if (gc[i - 1] == '0') {
						int t=i;
						
						while (gc[t - 1] == '0') {	
							gc[t - 1] = '9';
							t--;
						}
						
						//decrementing the non-zero digit by 1 as it is the one from where carry is taken
						int temp = gc[t-1];
						gc[t-1] = (char) (temp - 1);
						
					}else {	
						//simply decrementing previous digit by 1 if it is non-zero
						int temp = gc[i - 1];
						gc[i - 1] = (char) (temp - 1);
					}
			  }
			}else {
				//when smaller string is exhausted, 
				//simply appending greater string digits to result string
				sb.append(gi);
			}
		}
		
		//removing 0s from the beginning of actual result so as to avoid result of case 020 in case of 20
		int k = sb.length()-1;
		if(sb.charAt(k) == '0') {
			while(sb.charAt(k)=='0') {
				sb.deleteCharAt(k);
				k--;
			}
		}
		
		//reversing the string to get actual output since we were traversing the strings from end in the first place
		return sb.reverse().toString();
	}

}
