public class print1to100 {

    private static Object lock = new Object();
    private static int i = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (; i <= 100;) {
                synchronized (lock) {
                    System.out.println(i ++ + "：我是偶数");
                    try {
                        lock.notify();
                        if (i <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (; i <= 100;) {
                synchronized (lock) {
                    System.out.println(i ++ + "：我是奇数");
                    try {
                        if (i <= 100) {
                            lock.wait();
                        }
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        t2.start();
        t1.start();
    }
}
