package lsf.java._066_plusOne;
@SuppressWarnings("WeakerAccess")
public class PlusOne {
	 public int[] plusOne(int[] digits) {
		 for (int i = digits.length-1; i >=0; --i) {
			 if((++digits[i]%10)==0)
					digits[i]=0;
			else
				return digits;
		}
		if(digits[0]==0){
			int[] b=new int[digits.length+1] ;
			b[0]=1;
			return b;
		}
		return null;
	 } 
}