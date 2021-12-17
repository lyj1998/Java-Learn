import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
    /**
     * 需求：我们开发一个网站，需要对访问量进行统计，用户没发送一次请求，访问量+1,如何实现 ?
     * 我们模拟有100个人同时访问，并且每个人对咱们的网站发起10次请求，最后总访问次数应该是1000次
     */
    public class Test1 {
        static int count = 0;
        //模拟访问的方法
        public static void request() throws InterruptedException {
            //模拟耗时5毫秒
            //TimeUnit.MICROSECONDS.sleep(1);
            count++;
        }
        public static void main(String[] args) throws InterruptedException {
            long startTime = System.currentTimeMillis();
            int threadSize = 100;
            for (int i = 0; i<threadSize; i++){
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //模拟用户行为，每个用户访问10次网站
                            for(int j = 0; j <10; j++){
                                request();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
            //怎么保证100个线程结束之后，再执行后面代码？
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName()+",耗时:"+(endTime - startTime)+", count"+count);
        }
    }
