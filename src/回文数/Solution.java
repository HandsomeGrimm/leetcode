package 回文数;

/**
 *
 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 输入: 121
 输出: true

 */
public class Solution {

    public static boolean isPalindrome(int x) {

        if (x==0){
            return true;
        }

        if (x<0||x%10==0){
            return false;
        }

        int rev=0;
        //当左>右时，就不需要再进行了（已经得到了右边的值）
        while (x>rev){
            int temp=x%10;
            rev=rev*10+temp;
            x=x/10;
        }
        //偶数位：x==rev 奇数位：x==rev/10;
        return x==rev||x==rev/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1521));
    }


}
