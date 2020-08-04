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
        shellSortWithChange(nums);
        System.out.println(Arrays.toString(nums));

        int[] arr={4,1,3,2,6,5,8,9,7};

        for (int i = arr.length / 2; i > 0; i /= 2) {
            //i层循环控制步长
            for (int j = i; j < arr.length; j++) {
                //j控制无序端的起始位置
                for (int k = j; k > 0  && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k - i];
                        arr[k - i] = arr[k];
                        arr[k] = temp;
                    } else {
                        break;
                    }
                }
            }
            //j,k为插入排序，不过步长为i
        }
        System.out.println(Arrays.toString(arr));




    }


    public static void shellSortWithChange(int[] nums ){

        //i层循环控制步长
        for(int i=nums.length/2;i>0;i/=2){
            //j层控制无序端的起始位置
            for (int j=i;j<nums.length;j++){
                //j,k 为步长为i的插入排序
                for (int k=j;k>0&&k-i>0;k-=i){
                    if (nums[k]<nums[k-i]){
                        int temp=nums[k-i];
                        nums[k-i]=nums[k];
                        nums[k]=temp;
                    }else {
                        break;
                    }
                }
            }
        }



    }

}
