package 搜索插入位置;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 *输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 */
public class Solution {
    /**
     * 暴力查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int index=0;
        while (index<nums.length&&target>nums[index]){
            index+=1;
        }
        return index;
    }


    public static int betterSearchInsert(int[] nums, int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (target>nums[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int [] arr={1,3,5,6};
        System.out.println(betterSearchInsert(arr,3));
    }

}
