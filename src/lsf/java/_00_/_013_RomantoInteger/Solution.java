package lsf.java._00_._013_RomantoInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转int
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(check());
	}

	public static boolean check() {
		for (int i = 1; i < 4000; i++) {
			String s = intToRoman(i);
			if (romanToInt(s) != romanToInt2(s)) {
				System.out.println(i);
			}
		}
		return true;
	}

	public static String intToRoman(int num) {

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

	public static int romanToInt(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				num += 1000;
				break;
			case 'D':
				num += 500;
				break;
			case 'C':
				num += 100;
				break;
			case 'L':
				num += 50;
				break;
			case 'X':
				num += 10;
				break;
			case 'V':
				num += 5;
				break;
			case 'I':
				num += 1;
				break;
			}
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.substring(i, i + 2).equals("IV")) {
				num -= 2;
				++i;
			} else if (s.substring(i, i + 2).equals("IX")) {
				num -= 2;
				++i;
			} else if (s.substring(i, i + 2).equals("XL")) {
				num -= 20;
				++i;
			} else if (s.substring(i, i + 2).equals("XC")) {
				num -= 20;
				++i;
			} else if (s.substring(i, i + 2).equals("CD")) {
				num -= 200;
				++i;
			} else if (s.substring(i, i + 2).equals("CM")) {
				num -= 200;
				++i;
			}
		}
		return num;
	}

	public static int romanToInt2(String s) {
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
			if (map.get(s.charAt(i)) <= map.get(s.charAt(i - 1))) {
				num += map.get(s.charAt(i));
			} else {
				num = num - pre * 2 + map.get(s.charAt(i));
			}
			pre = map.get(s.charAt(i));
		}
		return num;
	}
}
