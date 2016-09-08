package lsf._014_LongestCommonPrefix;

/**
 * @author scolphew
 */
public class Solution {

    /**
     * 找到数组的最长公共字串
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        for (int i = 1; i < strs.length; i++) {
            strs[0] = commonPrefix(strs[0],strs[i]);
        }
        return strs[0];
    }

    public String commonPrefix(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        for(int i=0,j=0;i<s1.length() && j<s2.length();++i,++j){
            if(s1.charAt(i) == s2.charAt(j))
                sb.append(s1.charAt(i));
            else
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"abcasasa","abd","abc"}));
        System.out.println(s.longestCommonPrefix(new String[]{}));
    }
}
