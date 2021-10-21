package syn;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
//线程不安全的集合
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        final List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                //启动1000个线程，但是在同一个位置索引，可能会有两个线程add，因此元素就被覆盖了
                public void run() {
                    synchronized (list){
                        list.add(Thread.currentThread().getName());
                    }

                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());

    }
}


