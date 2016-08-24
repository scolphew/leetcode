package lsf._119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SameParameterValue", "WeakerAccess"})
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println( s.getRow(3)  );
	}

	/**
	 * 杨辉三角单独行
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if(rowIndex==0)
			return list;
		for (int i = 1; i < rowIndex; i++) {
			list.add( c(rowIndex,i) );
		}
		list.add(1);
		return list;
	}

	public int c(int n, int m) {
		long sub = 1;
		if(m<=n/2){
			for (int i = 1, j = n; m>0; ++i,--j,--m) {
				sub*=j;
				sub/=i;
			}
			return (int) sub;
		}
		else 
			return c(n,n-m);
	}
}
