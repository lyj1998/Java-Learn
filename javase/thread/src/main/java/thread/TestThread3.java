package thread;

//买火车票的例子
//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
/**
 * 初始并发：
 * 小红正在买第10张票
 小红正在买第9张票
 小红正在买第8张票
 小张正在买第10张票
 小张正在买第6张票
 小张正在买第5张票
 小张正在买第4张票
 小张正在买第3张票
 小张正在买第2张票
 小明正在买第10张票
 小张正在买第1张票
 小红正在买第7张票
 */
public class TestThread3 implements Runnable {
    //票数
    private int ticketName = 10;

    public void run() {
        while(true){
            if (ticketName<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"正在买第"+ticketName--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "小红").start();
        new Thread(ticket, "小张").start();
    }
}
