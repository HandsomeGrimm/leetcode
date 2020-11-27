package list按照某个属性排序;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static List sort(List list, final String sortName, final String direction) {
        Collections.sort(list, new Comparator() {
            public int compare(Object a, Object b) {
                try {
                    //根据属性名获取到field
                    Field field = a.getClass().getDeclaredField(sortName);
                    //field设置为public访问属性.
                    field.setAccessible(true);

                    //获取该属性的类型
                    Class typeClass = field.getType();
                    //int排序
                    if (typeClass.equals(Integer.class)) {
                        Integer one = (Integer) field.get(a);
                        Integer two = (Integer) field.get(b);

                        if ("desc".equals(direction)) {
                            return two - one;
                        } else {
                            return one - two;
                        }
                    } else {//String排序
                        String one = (String) field.get(a);
                        String two = (String) field.get(b);

                        if ("desc".equals(direction)) {
                            return two.compareTo(one);
                        } else {
                            return one.compareTo(two);
                        }
                    }
                } catch (Exception e) {
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw, true));
                }
                return 1;

            }
        });
        return list;
    }

    public static void main(String[] args) {
        List<Person> people=new LinkedList<>();
        Person person1=new Person();
        person1.setName("王林刚");
        person1.setAge(22);
        person1.setProfit("33.8");

        Person person2=new Person();
        person2.setName("罗航");
        person2.setAge(23);
        person2.setProfit("30.8");

        Person person3=new Person();
        person3.setName("张宇");
        person3.setAge(18);
        person3.setProfit("13.75");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        List<Person> after=sort(people,"age","desc");
        System.out.println(after);

    }



}




