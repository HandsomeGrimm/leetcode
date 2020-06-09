package 创建线程的几种方式;

/**
 * @author HandsomeGrimm
 * @Date: 2020/4/13 09:38
 * @Description: 通过继承Thread实现线程
 */
public class ThreadTest extends Thread{

    /**
     *
     * 功能描述:    使用继承Thread实现时，多个线程之间无法共享线程类的实例变量
     *
     * @param:
     * @return:
     * @auther: HandsomeGrimm
     * @date: 2020/4/13 9:52
     */
    @Override
    public void run(){
        for (int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+" is running "+i);
        }

    }

    public static void main(String[] args) {
        for (int j=0;j<50;j++){
            if (j==20){
                new ThreadTest().start();
                new ThreadTest().start();
            }
        }
    }


}
