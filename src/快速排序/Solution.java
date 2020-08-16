package 快速排序;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums={-9,78,0,23,-567,70};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


    public static void quickSort(int[] nums,int left,int right){

        int l=left;
        int r=right;
        int m=nums[(left+right)/2] ;
        int temp=0;
        while (l<r){
            while (nums[l]<m){
                l++;
            }
            while (nums[r]>m){
                r--;
            }
            if (l>=r){
                break;
            }

            //交换
            temp=nums[r];
            nums[r]=nums[l];
            nums[l]=temp;

            if (nums[l]==m){
                r-=1;
            }
            if (nums[r]==m){
                l+=1;
            }



        }

        if (l==r){
            l+=1;
            r-=1;
        }

        if (left<r){
            quickSort(nums,left,r);
        }

        if (right>l){
            quickSort(nums,l,right);
        }


    }

}
