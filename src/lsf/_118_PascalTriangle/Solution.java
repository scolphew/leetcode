package lsf._118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		
		System.out.println( s.generate(1) );
	}
	/**
	 * 杨辉三角
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> returnList=new  ArrayList<List<Integer>>();
		if(numRows==0) return  returnList ;
		List<Integer> thisList=new ArrayList<Integer>();
		thisList.add(1);
		returnList.add(thisList);
		//从第二行开始
		for (int i = 2; i <=numRows; i++) {
			thisList=new ArrayList<Integer>();
			thisList.add(1);
			//除了本行首尾
			for (int j = 1; j <i-1; j++) {
				int a=returnList.get(i-2).get(j-1);
				int b=returnList.get(i-2).get(j);
				thisList.add(a+b);
			}
			thisList.add(1);
			returnList.add(thisList);
		}
		return returnList;
	}
}
