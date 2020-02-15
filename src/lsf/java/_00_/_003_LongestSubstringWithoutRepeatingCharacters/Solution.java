package lsf.java._00_._003_LongestSubstringWithoutRepeatingCharacters;

/**
 * 寻找最长的不带不重复字符的子串
 * 例：
 * 	"abcabcbb" --> "abc"
 * 	"bbbbb" --> "b"
 * 	"pwwkew" --> "wke"
 */
public class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		String l="ddddaaass";
		System.out.println(s.lengthOfLongestSubstring(l));
	}
	
	/**
	 * 第二次出现
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
//		if(s.length()==0)
//			return 0;
		int last[]=new int[128];
		for (int i = 0; i < 128; i++) {
			last[i]=-1;
		}
		int max=0,start=-1;
		for (int i = 0; i < s.length(); i++) {
			int x=last[s.charAt(i)];//上一次

			if( x<start ){			//向前到start
				if(i-start>max){
					max=i-start;
				}
			}else{                 //向前到i
				if(i-x>max){
					max=i-x;
				}
			}
			if(x!=-1){
				start=x>start?x:start;
			}
			last[s.charAt(i)]=i;
		}
		return max;
	}
}
