package lsf.java._07_._781_RabbitsinForest;

public class Solution {

    public int numRabbits(int[] answers) {
        int count = 0;
        int[] nums = new int[1000];
        for (int i : answers) {
            if(i==0){
                count++;
            }
            if (nums[i] == 0) {
                count += i + 1;
                nums[i]+=1;
            } else if (nums[i] == i) {
                nums[i] = 0;
            } else {
                nums[i]++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numRabbits(new int[]{1,2,3,4,5,6,7,8}));
    }

}
