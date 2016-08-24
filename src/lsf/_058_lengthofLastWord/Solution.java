package lsf._058_lengthofLastWord;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println( s.lengthOfLastWord("hhh sssa ")  );
	}

	/**
	 *  Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	 *	给定一个字符串s由上/小写字母和空的空间字符''，返回字符串的最后一个字的长度。
	 *	If the last word does not exist, return 0.
	 *	如果最后一个字不存在，则返回0。
	 *	Note: A word is defined as a character sequence consists of non-space characters only.
	 *	注：一个字被定义为一个字符序列只包括非空格字符。
	 *	For example,
	 *	Given s = "Hello World",
	 *	return 5. 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int j=0,i=s.length()-1;
		//去掉最后的空格
		for (; i>=0; --i) {
			if(s.charAt(i)!=32)
				break;
		}
		//从后往前便利
		for (; i >=0; i--,j++) {
			if( s.charAt(i)==32)
				return j;
		}
		return j;
	}
}
