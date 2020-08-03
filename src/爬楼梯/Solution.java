package 爬楼梯;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class Solution {
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }

        int sum1=1;
        int sum2=2;
        for (int i=3;i<=n;i++){
            //f(x)=f(x-1)+f(x-2)
            //总步数等于上一阶的总步数+1（走一步）与上两阶的步数+1（走两步）的和
            int temp=sum1+sum2;
            sum1=sum2;
            sum2=temp;
        }

        return sum2;

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
