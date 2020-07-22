package 多线程操作字符串;

import java.util.concurrent.*;

public class Solution {

    public  static String str = "strA";

    public static void main(String[] args) throws Exception {
        for (int i=0;i<5;i++){
            Thread.sleep(3000);
            new Thread(new Add().call()).start();
            new Thread(new Del().call()).start();
        }

        System.out.println(str);
    }

     static class  Add implements Callable<String> {

        @Override
        public String call() throws Exception {
//            synchronized (this){
                str=str+"a";
                return "a";
//            }
        }
    }

    static class Del implements Callable<String>{

        @Override
        public String call() throws Exception {
//            synchronized (this){
                str=str.substring(1);
                return "b";
//            }
        }
    }

}
