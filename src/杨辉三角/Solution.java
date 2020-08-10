package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Solution {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if (numRows==0){
            return result;
        }
        for (int i=0;i<numRows;i++){
            List<Integer> sum=new ArrayList<>();
            for (int j=0;j<=i;j++){
                //两边都为1
                if (j==0||j==i){
                    sum.add(1);
                }else {
                    sum.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result=generate(5);
        System.out.println(result);
    }

}
