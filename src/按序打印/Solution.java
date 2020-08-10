package 按序打印;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 我们提供了一个类：

 public class Foo {
 public void one() { print("one"); }
 public void two() { print("two"); }
 public void three() { print("three"); }
 }

 三个不同的线程将会共用一个 Foo 实例。

 线程 A 将会调用 one() 方法
 线程 B 将会调用 two() 方法
 线程 C 将会调用 three() 方法
 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
  

 输入: [1,2,3]
 输出: "onetwothree"
 解释:
 有三个线程会被异步启动。
 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 正确的输出是 "onetwothree"。

 输入: [1,3,2]
 输出: "onetwothree"
 解释:
 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 正确的输出是 "onetwothree"。

 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。

 你看到的输入格式主要是为了确保测试的全面性。

 *
 */
public class Solution {

    public static void main(String[] args) {
        Foo foo=new Foo();
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("one");
            }
        };

        Runnable r2=new Runnable() {
            @Override
            public void run() {
                System.out.println("two");
            }
        };

        Runnable r3=new Runnable() {
            @Override
            public void run() {
                System.out.println("three");
            }
        };

        try {
            foo.first(r1);
            foo.third(r3);
            foo.second(r2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
class Foo {

    private AtomicInteger firstDone=new AtomicInteger(0);
    private AtomicInteger secondDone=new AtomicInteger(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstDone.get()!=1){
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondDone.get()!=1){
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

