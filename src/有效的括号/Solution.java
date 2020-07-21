package 有效的括号;


import java.util.Set;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 输入: "()"
 * 输出: true
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 输入: "([)]"
 * 输出: false
 *
 */
public class Solution {

    public static boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        if (s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']'){
            return false;
        }

        char [] arr=s.toCharArray();
        Stack<Character> valid=new Stack<>();
        for (int i=0;i<arr.length;i++){
            //压入栈的情况
            if (arr[i]=='('||arr[i]=='{'||arr[i]=='['){
                valid.push(arr[i]);
            } else{
                //若栈为空 已经不满足了
                if (valid.isEmpty()){
                    return false;
                }
                //获取当前栈顶
                char top=valid.peek();
                //匹配就出栈
                if (arr[i]==')'&&top=='('){
                    valid.pop();
                }else if (arr[i]==']'&&top=='['){
                    valid.pop();
                }else if (arr[i]=='}'&&top=='{'){
                    valid.pop();
                }else {
                    //防止空字符、特殊字符等情况
                    valid.push(arr[i]);
                }

            }
        }
        return valid.isEmpty();
    }


    public static void main(String[] args) {
        String s="(])";
        System.out.println(isValid(s));
    }

}
