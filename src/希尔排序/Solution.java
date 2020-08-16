package 希尔排序;

import sun.rmi.server.InactiveGroupException;

import java.util.Arrays;

/**
 * 插入排序变种版
 *
 *　　a、基本上和插入排序一样的道理
 *
 * 　　b、不一样的地方在于，每次循环的步长，通过减半的方式来实现
 *
 * 　　c、说明：基本原理和插入排序类似，不一样的地方在于。通过间隔多个数据来进行插入排序。
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[]nums={4,1,3,2,6,5,8,9,7};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //交换式
    public static void shellSortWithChange(int[] nums ){
        int temp=0;
        //i层循环控制步长
        for(int i=nums.length/2;i>0;i/=2){
            //j层控制无序端的起始位置
            for (int j=i;j<nums.length;j++){
                //j,k 为步长为i的插入排序
                for (int k=j;k>0;k-=i){

                    if (nums[k]<nums[k-i]){
                        temp=nums[k-i];
                        nums[k-i]=nums[k];
                        nums[k]=temp;
                    }else {
                        break;
                    }
                }
            }
            System.out.println("第"+i+"轮排序后的情况："+Arrays.toString(nums));
        }
    }

    public static void shellSort(int[] nums) {

        for (int i = nums.length / 2; i > 0; i /= 2) {
            for (int j = i; j < nums.length; j++) {
                int k = j;
                int temp = nums[k];
                if (nums[k]<nums[k-i]){
                    while (k - i >= 0 && temp< nums[k - i]) {
                        nums[k] = nums[k - i];
                        k -= i;
                    }
                    nums[k] = temp;
                }

            }
            System.out.println("第"+i+"轮排序后的情况："+Arrays.toString(nums));
        }
    }

}
