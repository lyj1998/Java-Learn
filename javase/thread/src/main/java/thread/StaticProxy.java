package thread;

/**
 * 静态代理模式总结：
 *     真实对象和代理对象都要实现同一个接口
 *     代理对象要代理真实角色
 *
 * 好处：
 *     代理对象可以做很多真实对象做不了的事情
 *     真实对象专注做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}

interface Marry{
    void happyMarry();
}

class  You implements Marry{
    public void happyMarry() {
        System.out.println("啦啦啦啦啦，结婚快乐吗？");
    }
}

class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收集尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置会场");
    }

}