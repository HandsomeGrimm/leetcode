package 最大子序和;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class Solution {

    //自己想的
    public static int maxSubArray(int[] nums) {
        int len=nums.length;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                int sum=0;
                for (int m=i;m<=j;m++){
                    sum+=nums[m];
                }
                max=Math.max(max,sum);
            }
        }

        return max;
    }


    //题解

    /**
     *  动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
     *  如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     *  如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     *  每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     *
     */
    public static int betterSolution(int[] nums){
        int result=nums[0];
        int sum=0;
        for (int num:nums){
            if (sum>0){
                sum=sum+num;
            }else {
                sum=num;
            }
            result=Math.max(result,sum);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

}
