package 最长回文子串;


import sun.plugin2.applet.context.NoopExecutionContext;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 */
public class Solution {

    //动态规划
    public static String longestPalindrome(String s) {
        int len=s.length();

        if (len<2){
            return s;
        }

        int maxLen=1;
        int begin=0;
        //dp[i][j] 表示s[i...j] 是否是回文串
        boolean [] [] dp=new boolean[len][len];
        for (int i=0;i<len;i++){
            dp[i][i]=true;
        }
        char[] ss=s.toCharArray();

        for (int j=1;j<len;j++){
            for (int i=0;i<j;i++){

                if (ss[i]!=ss[j]){
                    //若首尾不等
                    dp[i][j]=false;
                }else {
                    if (j-i<3){
                        //头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if (dp[i][j]&&j-i+1>maxLen){
                    //长度
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }


    public static void main(String[] args) {
        String s="abcbaaa";
        System.out.println(longestPalindrome(s));

    }

}
