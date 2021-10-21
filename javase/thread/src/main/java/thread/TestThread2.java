package thread;

public class TestThread2 implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码================="+i);
        }
    }

    public static void main(String[] args) {
        TestThread2 testThread2 = new TestThread2();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(testThread2).start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在写代码================"+i);
        }
    }
}
