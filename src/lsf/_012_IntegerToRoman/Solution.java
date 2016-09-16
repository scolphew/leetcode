package lsf._012_IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * Int转罗马数字
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.romanToInt("DCXXI"));
		System.out.println(s.romanToInt("DCXI"));
	}

	public String intToRoman(int num) {

		int val[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String r[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
				"V", "IV", "I" };
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			while (num >= val[i]) {
				sb.append(r[i]);
				num -= val[i];
			}
			i++;
		}
		return sb.toString();
	}

	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);

		int num = map.get(s.charAt(0));
		int pre = num;
		for (int i = 1; i < s.length(); i++) {
			int thisNum = map.get(s.charAt(i));
			if (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1))) {
				num += thisNum;
			} else {
				num = num - pre * 2 + thisNum;
			}
			pre = thisNum;
		}
		return num;
	}
	
	
	
	
}
