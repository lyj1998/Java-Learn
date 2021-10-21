package state;

public class TestYield implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }

    public static void main(String[] args) {
        new Thread(new TestYield(), "a").start();
        new Thread(new TestYield(), "b").start();
    }
}
