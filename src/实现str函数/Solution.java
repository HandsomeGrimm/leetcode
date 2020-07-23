package 实现str函数;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 */
public class Solution {

    //逐一匹配
    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0){
            return 0;
        }
        if (haystack==null||haystack.length()==0||haystack.length()<needle.length()){
            return -1;
        }
        int hLength=haystack.length();
        int nLength=needle.length();

        for (int i=0;i<hLength-nLength+1;i++){
            if (haystack.substring(i,i+nLength).equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "aaaaa", needle = "ll";
        System.out.println(strStr(haystack,needle));
    }


}
