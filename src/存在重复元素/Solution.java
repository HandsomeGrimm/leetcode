package 存在重复元素;

import java.util.HashSet;

/**
*   @author: zhangy
*   @Date: 2020/12/7 10:42
*   @description: 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 *
 *输入: [1,2,3,4]
 * 输出: false
 *
*/
public class Solution {

    public static boolean containsDuplicate(int[] nums) {
        //set.add()如果失败，则说明存在重复元素
        HashSet<Integer> set=new HashSet<>();
        for (int i:nums){
            if (!set.add(i)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,7};
        System.out.println(containsDuplicate(nums));
    }
}
