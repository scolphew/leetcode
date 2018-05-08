package lsf.java._258_AddDigits;

@SuppressWarnings("WeakerAccess")
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println( "1-"+s.addDigits(1));
		System.out.println("2-"+s.addDigits2(1));
		System.out.println(  (-1)%9  );
	}

	/**
	 *  Given a non-negative integer num, 
	 *  repeatedly add all its digits until the result has only one digit.
	 *  For example:
	 *  Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
	 *  Since 2 has only one digit, return it. 
	 * @param num
	 * @return
	 */
	public int addDigits(int num) {
		if(num<10)
			return num;
		int x=0;
		
		while(num>0){
			x+=num%10;
			num/=10;
		}
		return addDigits(x);
	}
	public int addDigits2(int num) {
		return   ((--num)%9)+1;
	}
}
