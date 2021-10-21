package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 练习Thread，实现多线程同步下载图片
 */
//联系Thread，实现多线程同步下载图片
public class TestThread1 extends Thread{
  private String name;
  private String url;
    public TestThread1(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为:"+name);
    }

    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1("1.jpg", "https://i0.hdslb.com/bfs/sycp/creative_img/202109/008abdc098d3c62ed328395336e0169f.jpg");
        TestThread1 t2 = new TestThread1("2.jpg", "https://i0.hdslb.com/bfs/sycp/creative_img/202109/008abdc098d3c62ed328395336e0169f.jpg");
        TestThread1 t3 = new TestThread1("3.jpg", "https://i0.hdslb.com/bfs/sycp/creative_img/202109/008abdc098d3c62ed328395336e0169f.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }


}
