package 冒泡排序;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Solution {
    /**
     * 逐一比較，将大的后移
     * @param chars
     * @return
     */
    public static void bubbleSorting(int [] chars){
        int len=chars.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if (chars[j]<chars[i]){
                    int temp=chars[i];
                    chars[i]=chars[j];
                    chars[j]=temp;
                }
            }
        }
    }

    /**
     * 算法优化：只要当前发生了排序了，此次循环其实就可以结束了
     * @param chars
     */
    public static void betterBubbleSorting(int [] chars){
        int len=chars.length;
        boolean flag=false;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if (chars[j]<chars[i]){
                    int temp=chars[i];
                    chars[i]=chars[j];
                    chars[j]=temp;
                    flag=true;
                }
            }
            if (!flag){
                break;
            }else {
                flag=true;
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

        betterBubbleSorting(ints);
//        bubbleSorting(ints);

        Date date2=new Date();
        String s2=format.format(date2);
        System.out.println(s2);
    }


}
