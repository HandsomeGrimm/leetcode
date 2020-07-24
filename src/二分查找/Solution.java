package 二分查找;

public class Solution {

    public static int binaryResearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (target>nums[mid]){
                left=mid+1;
            }else if (target<nums[mid]){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,7,9};
        System.out.println(binaryResearch(nums,5));
    }


}
