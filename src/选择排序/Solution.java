package 选择排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * 　　a、将第一个值看成最小值
 *
 * 　　b、然后和后续的比较找出最小值和下标
 *
 * 　　c、交换本次遍历的起始值和最小值
 *
 * 　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值。
 *
 */
public class Solution {


    public static void selectSort(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            //假定当前为最小
            int min=arr[i];
            int minIndex=i;

            //每次子循环选出最小值
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            //交换，下标后移(前面的确定后 就不动了)
            if (minIndex!=i){
                //优化：minIndex=i时说明当前顺序是OK的，故不用交换
                arr[minIndex]=arr[i];
                arr[i]=min;
            }

        }
    }


    public static void main(String[] args) {
        int [] ints=new int[80000];
        for (int i=0;i<80000;i++){
            ints[i]= (int) (Math.random()*1000);
        }

        Date date1=new Date();
        SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String s1=format.format(date1);
        System.out.println(s1);

        selectSort(ints);

        Date date2=new Date();
        String s2=format.format(date2);
        System.out.println(s2);

    }


}
