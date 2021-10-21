package state;

/**
 * sleep:
 * 一般用来模拟网络延时，模拟倒计时
 * 每个对象都有一把锁，sleep不会释放锁
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {
    public static void main(String[] args) {
        tenDown();
        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());//更新当前
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static  void  tenDown(){
        int num = 10;
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if(num<=0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
