package 青蛙跳台阶;

import java.util.HashMap;
import java.util.Map;

/**
*   @author: zhangy
*   @Date: 2020/10/14 11:09
*   @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
*/

public class Solution {


    /**
    *   @author: zhangy
    *   @Date: 2020/10/14 11:11
    *   @description: 传统递归
    */
    public static int totalWays(int n){

        if (n==0){
            return 0;
        }
        if (n<=2){
            return n;
        }

        return totalWays(n-1)+totalWays(n-2);
    }


    /**
    * @Description 带缓存的递归解法，因为传统递归每次f(n-2)...f(2)都会被重复计算，所以设置缓存
    * @Author  zhangy
    * @Date   2020/10/14 11:14
    * @Param
    * @Return
    */
    Map<Integer,Integer> waysCache=new HashMap<>();
    public  int totalWaysWithCache(int n){
        if (n==0){
            return 0;
        }
        if (n<=2){
            return n;
        }

        if (waysCache.containsKey(n)){
            return waysCache.get(n);
        }else {
            waysCache.put(n,totalWaysWithCache(n-1)+totalWaysWithCache(n-2));
            return waysCache.get(n);
        }


    }


    public static void main(String[] args) {
//        System.out.println(totalWays(5));
//        Solution solution=new Solution();
//        System.out.println(solution.totalWaysWithCache(5));
        System.out.println(Integer.MAX_VALUE);
    }

}
