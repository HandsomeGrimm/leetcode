package 最长公共前缀;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 */

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String res=strs[0];

        for (int i=0;i<strs.length;i++){
            for (int j=0;j<res.length()&&j<strs[i].length();j++){
                if (res.charAt(j)!=strs[i].charAt(j)){
                    //因为是公共前缀 所以只要存在不同的就可以直接跳出了
                    res=res.substring(0,j);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String [] s={"flower","flow","flight"};

        String []s1={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(s1));
    }


}
