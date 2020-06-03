package lsf.java._07_._722_RemoveComments;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        boolean inBlock = false;

        for (String s : source) {
            char[] chars = s.toCharArray();
            int i = 0;
            if (!inBlock) {
                sb.delete(0, sb.length());
            }
            while (i < chars.length) {
                if (!inBlock) {                                                               //正常代码
                    if (chars[i] == '/') {
                        if (i + 1 < chars.length) {                                           //没有结束
                            if (chars[i + 1] == '/') {                                        //行注释
                                break;                                                        //---结束本行
                            } else if (chars[i + 1] == '*') {                                 //块注释
                                i++;                                                          //继续之后的内容
                                inBlock = true;
                            }else {
                                sb.append(chars[i]);
                            }
                        } else {
                            sb.append(chars[i]);
                        }
                    } else {
                        sb.append(chars[i]);
                    }
                } else {                                                                   //注释块内
                    if (chars[i] == '*') {
                        if (i + 1 < chars.length && chars[i + 1] == '/') {                 //结束循环
                            inBlock = false;
                            i++;
                        } else {
                            // No Action
                        }
                    }
                }
                i++;
            }
            if (!inBlock && sb.length() > 0) {
                ans.add(sb.toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeComments(new String[]{
                "void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"
        }));
    }

}




