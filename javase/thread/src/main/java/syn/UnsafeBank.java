package syn;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account("银行", 100);
        Drawing me = new Drawing(account, 50, "老张");
        Drawing boyFriend = new Drawing(account, 100, "boyFriend");
         me.start();
         boyFriend.start();
    }


}


class Account{
    String name;//账户名
    int money;//账户余额

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}
class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;
    public Drawing(Account account, int drawingMoney, String name) {
        //Thread.setName()  用父类的构造方法取名字
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
      synchronized (account){
          //判断有没有钱
          if (drawingMoney-account.money>0){
              //因为继承了父类Thread类，所以可以直接调用getName的方法，不需要Thread.currentThread.getName()了
              System.out.println(this.getName()+"钱不够，取不出来了");
              return;
          }
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {

          }
          //卡内余额= 余额 - 你取的钱
          account.money = account.money - drawingMoney;
          //你手里的钱
          nowMoney = nowMoney + drawingMoney;
          System.out.println(account.name+"余额为:"+account.money);
          System.out.println(this.getName()+"当前现金为"+nowMoney);
      }
    }
}