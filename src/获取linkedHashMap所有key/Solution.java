package 获取linkedHashMap所有key;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        LinkedHashMap<String,Object> map=new LinkedHashMap();
        map.put("a","11");
        map.put("b","22");
        map.put("c","33");

        List<String> list=new LinkedList<>();
        for (Map.Entry<String,Object> m:map.entrySet()){
            list.add(m.getKey());
        }

        System.out.println(list);
    }

}
