package 创建线程的几种方式;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author HandsomeGrimm
 * @Date: 2020/4/13 10:03
 * @Description:
 */
public class CallableTest {

    public static void main(String[] args) {

        FutureTask<String> task=new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+" "+"开始执行任务！");

            TimeUnit.SECONDS.sleep(1);

            return "Grimm";
        });

        new Thread(task,"新线程").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (task.isDone()){
            try {
                System.out.println("Thread is done,the result is :"+task.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }


}
