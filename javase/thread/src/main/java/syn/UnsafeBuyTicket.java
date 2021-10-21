package syn;

public class UnsafeBuyTicket implements Runnable{
    //定义票的个数
    private static  int ticketNum = 10;
    private boolean flag = true;
    public void run() {
        while (flag) {
            buy();
        }
    }
    public synchronized  void buy(){
        //判断是否有票
        if(ticketNum<=0){
            this.flag = false;
            return;
        }
        //模拟延时，放大问题
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
               System.out.println(Thread.currentThread().getName()+"在买第"+ticketNum--+"张票");
        }

    public static void main(String[] args) {
        UnsafeBuyTicket unsafeBuyTicket = new UnsafeBuyTicket();
        new Thread(unsafeBuyTicket,"校长").start();
        new Thread(unsafeBuyTicket,"纪委").start();
        new Thread(unsafeBuyTicket,"院长").start();
    }
}
