package other.其他;

/**
 * @author scolphew
 */
public class 替换空格 {
    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c == '0')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
