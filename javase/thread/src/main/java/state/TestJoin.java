package state;

public class TestJoin implements Runnable {
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("join..."+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        for (int i = 0; i < 100; i++) {
            if (i==50){
                thread.join();
            }
            System.out.println("main.."+i);
        }
    }
}
