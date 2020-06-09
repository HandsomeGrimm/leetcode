package 数组实现队列;

import java.util.Scanner;

/**
 * @author HandsomeGrimm
 * @Date: 2020/4/11 16:19
 * @Description:
 */
public class QueueTest {
    public static void main(String[] args) {

        ArrayQueue queue=new ArrayQueue(3);
        char key=' ';
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;

        while (loop){

            System.out.println("s(show),显示队列");
            System.out.println("e(exit),退出程序");
            System.out.println("a(add),添加数据到队列");
            System.out.println("g(get),从队列获取数据");
            System.out.println("h(head),查看队列头的数据");
            key=scanner.next().charAt(0);

            switch (key){
                case 's':
                    queue.showQueueData();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                case 'a':
                    System.out.println("请输入需添加的数据");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("获取到的数据为：%d\n",result);
                        return;
                    }catch (Exception e){
                        System.out.println("数组为空~");
                    }
                case 'h':
                    try {
                        int result=queue.headQueue();
                        System.out.printf("获取到的数据为：%d\n",result);
                        return;
                    }catch (Exception e){
                        System.out.println("数组为空~");
                    }
            }
        }
        System.out.println("程序已退出~");

    }
}
