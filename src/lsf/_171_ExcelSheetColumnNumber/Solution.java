package lsf._171_ExcelSheetColumnNumber;

public class Solution {
	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}
	
	
	public static int titleToNumber(String s) {
		int sum=0;
		for (int i = 0; i < s.length(); i++) {
			sum*=26;
			sum+=+(s.charAt(i)-64); 
		}
		return sum;
	}
}
