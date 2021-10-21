package thread;

import java.util.concurrent.*;

public class TestThread4 implements Callable<Boolean> {
    private String name;
    private String url;
    public TestThread4(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread4 t1 = new TestThread4("1.jpg", "https://i0.hdslb.com/bfs/sycp/creative_img/202109/008abdc098d3c62ed328395336e0169f.jpg");
        TestThread4 t2 = new TestThread4("2.jpg", "https://i0.hdslb.com/bfs/sycp/creative_img/202109/008abdc098d3c62ed328395336e0169f.jpg");
        TestThread4 t3 = new TestThread4("3.jpg", "https://i0.hdslb.com/bfs/sycp/creative_img/202109/008abdc098d3c62ed328395336e0169f.jpg");
       //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r1.get();
        boolean rs3 = r1.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdown();

    }
}


