package syn;

import java.awt.*;
//死锁实际上就是互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
       Makeup g1 = new Makeup(0, "小卢");
       Makeup g2 = new Makeup(1, "校长");
       g1.start();
       g2.start();
    }
}


//口红
class LipStick{}
//镜子
class Mirror{}

class Makeup extends Thread{
    //重要的资源只有一份，用static来保证一份
    static LipStick lipStick = new LipStick();
    static  Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    Makeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (lipStick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);//一秒钟之后想拿镜子
                //造成死锁
//                synchronized (mirror){
//                    System.out.println(this.girlName+"获得镜子的锁");
                }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(2000);//两秒钟想拿口红
//                synchronized (lipStick){
//                    System.out.println(this.girlName+"获得口红的锁");
                }
            synchronized (lipStick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}
