package gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Lock lock = new Lock();
        new Thread(lock).start();
        new Thread(lock).start();
        new Thread(lock).start();
    }
}
class Lock implements Runnable{
 int ticketNum = 10;
 private final ReentrantLock lock= new ReentrantLock();
    public void run() {
        try {
            lock.lock();
            while (true){
                if (ticketNum>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                }else{
                    break;
                }
            }
        }finally {
            lock.unlock();
        }

    }
}
