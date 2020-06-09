package 数组实现队列;

/**
 * @author HandsomeGrimm
 * @Date: 2020/4/11 10:59
 * @Description:
 */
public class ArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//存放数据 模拟队列

    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列前一个位置
        rear=-1;//指向队尾实际的数据
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return front==rear;
    }


    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满~无法添加");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    //获取队列的数据
    public int getQueue(){
        if (isEmpty()){
            throw  new  RuntimeException("队列为空~无法获取！");
        }

        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueueData(){
        if (isEmpty()){
            System.out.println("队列为空~无法展示！");
            return;
        }
        for (int i =0;i< arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列投数据
    public int headQueue(){
        if (isEmpty()){
            throw  new  RuntimeException("队列为空~无法获取！");
        }
        return arr[front+1];
    }
}
