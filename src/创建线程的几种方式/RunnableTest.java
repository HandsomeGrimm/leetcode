package 创建线程的几种方式;

/**
 * @author HandsomeGrimm
 * @Date: 2020/4/13 09:54
 * @Description:
 */
public class RunnableTest implements Runnable {

    private int i;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is running "+i);
        i++;
    }

    public static void main(String[] args) {

        RunnableTest runnableTest=new RunnableTest();
        for (int i=0;i<50;i++){
            new Thread(runnableTest,"新线程1").start();
            new Thread(runnableTest,"新线程2").start();
        }

    }
}
