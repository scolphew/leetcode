package lsf._151_ReverseWordsinaString;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		String x = s.reverseWords("   a   b ");
		System.out.println("---" + x + "-----");
	}

	/**
	 * Given an input string, reverse the string word by word. For example Given
	 * s = "the sky is blue", return "blue is sky the".
	 */
	public String reverseWords(String s) {
		if(s.trim().isEmpty())
			return s.trim();
//		String[] string = s.trim().split(" ");
		//正则表达式
		String[] string = s.trim().split("[ ]+");
		
//		for (int i = 0; i < string.length; i++) {
//			System.out.println("<"+string[i]+">");
//		}
//		
		StringBuffer sb = new StringBuffer();
		for (int i = string.length - 1; i >= 0; --i) {
//			System.out.println("<"+string[i].trim()+">");
			sb.append(string[i].trim()).append(" ");
//			sb.append(" ");
		}
		return sb.toString().trim();
	}
}
