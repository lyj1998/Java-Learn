package state;

public class TestPriority implements  Runnable{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"->"+Thread.currentThread().getPriority());
        Thread t1 = new Thread(new TestPriority());
        Thread t2 = new Thread(new TestPriority());
        Thread t3 = new Thread(new TestPriority());
        Thread t4 = new Thread(new TestPriority());
        Thread t5 = new Thread(new TestPriority());
        Thread t6 = new Thread(new TestPriority());

        t1.start();
//先设置优先级，再启动
        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

//        t5.setPriority(-1);
//        t5.start();
//
//        t6.setPriority(11);
//        t6.start();

    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+"->"+Thread.currentThread().getPriority());
    }
}
