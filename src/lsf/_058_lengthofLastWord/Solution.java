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
	 *	����һ���ַ���s����/Сд��ĸ�ͿյĿռ��ַ�''�������ַ��������һ���ֵĳ��ȡ�
	 *	If the last word does not exist, return 0.
	 *	������һ���ֲ����ڣ��򷵻�0��
	 *	Note: A word is defined as a character sequence consists of non-space characters only.
	 *	ע��һ���ֱ�����Ϊһ���ַ�����ֻ�����ǿո��ַ���
	 *	For example,
	 *	Given s = "Hello World",
	 *	return 5. 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
		int j=0,i=s.length()-1;
		//ȥ�����Ŀո�
		for (; i>=0; --i) {
			if(s.charAt(i)!=32)
				break;
		}
		//�Ӻ���ǰ����
		for (; i >=0; i--,j++) {
			if( s.charAt(i)==32)
				return j;
		}
		return j;
	}
}
