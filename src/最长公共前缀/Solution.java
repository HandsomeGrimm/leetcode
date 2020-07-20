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

        for (int i=1;i<strs.length;i++){

            int j=0;
            for (;j<res.length()&&j<strs[i].length();j++){
                if (res.charAt(j)!=strs[i].charAt(j)){
                    //因为是公共前缀 所以只要存在不同的就可以直接跳出了
                    break;
                }
            }
            //放外面是为了保证 存不存在都要保证切割（某一字符串可能长度不够，这样就进不到不相等的条件 所以只能在外面切割）
            res=res.substring(0,j);
        }
        return res;
    }

    public static void main(String[] args) {
        String [] s={"flower","flow","flight"};

        String []s1={"aa","a"};
        System.out.println(longestCommonPrefix(s1));
    }


}
