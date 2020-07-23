package 插入排序;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int [] arr={8,5,3,4,12,20};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void  insertSort(int [] arr){

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
        }
    }


}
