package 多线程操作字符串;

import sun.nio.ch.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Solution {

    public  static String str = "strA";

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date())+"时str= "+str);
        ScheduledExecutorService ses=Executors.newScheduledThreadPool(2);
        for (int i=0;i<5;i++){
            ScheduledFuture<String> scheduledFuture=ses.schedule(new Add(),3,TimeUnit.SECONDS);
            ScheduledFuture<String> scheduledFuture1=ses.schedule(new Del(),3,TimeUnit.SECONDS);
            System.out.println(scheduledFuture1.get());
        }
        ses.shutdown();
        System.out.println(sdf.format(new Date())+"时str= "+str);
    }

     static class  Add implements Callable<String> {

        @Override
        public String call() throws Exception {
                str=str+"a";
                SimpleDateFormat s1=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
                System.out.println(Thread.currentThread().getName()+ s1.format(new Date())+" 执行了add后为："+str);
                return str;
        }
    }

    static class Del implements Callable<String>{

        @Override
        public String call() throws Exception {
                if (str.length()>0){
                    str=str.substring(1);
                    SimpleDateFormat s1=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
                    System.out.println(Thread.currentThread().getName()+ s1.format(new Date())+" 执行了del后为："+str);
                    return str;
                }else {
                    return str;
                }
        }
    }

}
