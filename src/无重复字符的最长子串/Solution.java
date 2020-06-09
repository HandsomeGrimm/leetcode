package 无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HandsomeGrimm
 * @Date: 2020/3/31 14:00
 * @Description:
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s){
        int n=s.length();
        int answer=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int start=0,end=0;end<n;end++){
            char alpha=s.charAt(end);

            if (map.containsKey(alpha)){
                start=Math.max(map.get(alpha),start);
            }

            answer=Math.max(answer,end-start+1);

            map.put(s.charAt(end),end+1);
        }
        return answer;
    }


    public static void main(String[] args) {
        String s="abcacbcabcd";
        System.out.println(lengthOfLongestSubstring(s));

    }


}
