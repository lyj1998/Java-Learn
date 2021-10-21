package state;

public class TestDaemon implements Runnable {

    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(new TestDaemon()).start();
    }
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你健康地活着");
        }
        System.out.println("Goodbye=====this World!");
    }
}
class God implements Runnable{
    public void run() {
       while (true){
           System.out.println("上帝永远守护着我们");
       }
    }
}
