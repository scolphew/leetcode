package lsf._125_ValidPalindrome;

@SuppressWarnings({"SameParameterValue", "WeakerAccess"})
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		
		System.out.println('a'-'A');
		System.out.println( s.isPalindrome("A man, a plan, a canal: Panama") );
	}

	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases. For example,
	 * "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a
	 * palindrome.
	 */
	public boolean isPalindrome(String s) {
		int i=0,j=s.length()-1;
		while(i<j){
			if(Character.isLetterOrDigit( s.charAt(i) ) ){
				if(Character.isLetterOrDigit( s.charAt(j) ) ){
					if((s.charAt(i)-s.charAt(j))==0 
							||  Math.abs( (s.charAt(i)-s.charAt(j)))==32){
						++i;
						--j;
					}else{
						System.out.println(i+" "+j);
						return false;
					}
				}else {
					--j;
				}
			}else{
				++i;
			}
		}
		return true;
	}

}
