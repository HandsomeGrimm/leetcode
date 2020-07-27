package 加一;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 */
public class Solution {

    public static int[] plusOne(int[] digits) {
        if (digits.length==1&&digits[0]==0){
            digits[0]=1;
            return digits;
        }
        for (int i=digits.length-1;i>=0;i--){
            digits[i]=digits[i]+1;
            digits[i]=digits[i]%10;
            //加一得十进一位个位数为 00 加法运算如不出现进位就运算结束了且进位只会是一
            //所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 11 个位数置为 00，如此循环直到判断没有再进位就退出循环返回结果
            if (digits[i]!=0){
                return  digits;
            }
        }

        //然后还有一些特殊情况就是当出现 9999、999999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(Arrays.toString(plusOne(nums)));
    }


}
