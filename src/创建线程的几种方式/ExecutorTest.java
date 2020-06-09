package 创建线程的几种方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HandsomeGrimm
 * @Date: 2020/4/13 10:56
 * @Description: 通过线程池启动多线程: 通过Executor 的工具类可以创建三种类型的普通线程池。
 */
public class ExecutorTest {

    /**
     *
     * 功能描述: 固定大小的线程池: 使用于为了满足资源管理需求而需要限制当前线程数量的场合。使用于负载比较重的服务器。
     *
     * @param:
     * @return:
     * @auther: HandsomeGrimm
     * @date: 2020/4/13 11:01
     */
    /*public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(5);

        for (int i=0;i<5;i++){
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        System.out.println(Thread.currentThread().getName()+" number: "+j);
                    }
                }
            });
        }
        ex.shutdown();
    }*/
    
    
    /**
     *
     * 功能描述: 单线程池: 需要保证顺序执行各个任务的场景
     *
     * @param: 
     * @return: 
     * @auther: HandsomeGrimm
     * @date: 2020/4/13 11:02
     */
    /*public static void main(String[] args) {
        ExecutorService ex=Executors.newSingleThreadExecutor();

        for (int i=0;i<5;i++){
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        System.out.println(Thread.currentThread().getName()+" number: "+j);
                    }
                }
            });
        }
        ex.shutdown();
    }*/
    
    /**
     *
     * 功能描述: 缓存线程池: 当提交任务速度高于线程池中任务处理速度时，缓存线程池会不断的创建线程
     *                     适用于提交短期的异步小程序，以及负载较轻的服务器
     * @param:
     * @return: 
     * @auther: HandsomeGrimm
     * @date: 2020/4/13 11:04
     */
    public static void main(String[] args) {
        ExecutorService ex=Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        System.out.println(Thread.currentThread().getName()+" number: "+j);
                    }
                }
            });
        }
        ex.shutdown();
    }

}
