package 插入排序;

import java.util.Arrays;

/**
 *     a、默认从第二个数据开始比较。
 *
 * 　　b、如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
 *
 * 　　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出。
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        int [] arr={8,5,3,4,12,20};
        betterInsertSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void  betterInsertSort(int [] arr){

        //假定每次有序，每加一个自己来找位置
        for (int i=1;i<arr.length;i++){

            //待插入的数
            int insertValue=arr[i];
            //待插入数本身不需要比较了 从前面一个开始找位置
            int insertIndex=i-1;
            //insertIndex>=0保证在找位置时 不越界
            //insertValue<arr[insertIndex]说明还没找到位置
            while (insertIndex>=0&&insertValue<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            //找到插入位置后应该放位置后面
            arr[insertIndex+1]=insertValue;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static  void  insertSort(int[] nums){

        //外层循环，从第二个开始比较
        for (int i=1;i<nums.length;i++){
            //内层循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
            for (int j=i;j>0;j--){
                if (nums[j]<nums[j-1]){
                    int temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                }else {
                    //不小于 说明顺序OK 或者插入完毕 退出循环
                    break;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}
