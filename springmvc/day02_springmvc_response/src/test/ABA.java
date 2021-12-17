import java.util.concurrent.atomic.AtomicInteger;

public class ABA {
    public static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("操作线程"+Thread.currentThread().getName()+",初始值"+a.get());
                try {
                    int expectNum = a.get();
                    int newNum = expectNum + 1;
                    Thread.sleep(1000);//主线程休眠一秒钟，让出cpu
                    boolean isCASSuccess = a.compareAndSet(expectNum, newNum);
                    System.out.println("操作线程"+Thread.currentThread().getName()+"CAS操作"+isCASSuccess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"主线程");

        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20);//确保Thread-main线程优先执行
                    a.incrementAndGet();//a+1, a = 2
                    System.out.println("操作线程"+Thread.currentThread().getName()+".[increment],值"+a.get());
                    a.decrementAndGet();//a11, a = 1
                    System.out.println("操作线程"+Thread.currentThread().getName()+".[decrement],值"+a.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        main.start();
        other.start();
    }

}
