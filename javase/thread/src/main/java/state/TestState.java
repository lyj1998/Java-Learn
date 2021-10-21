package state;

public class TestState implements Runnable{
    public static void main(String[] args) {
         Thread thread = new Thread(new TestState());
         //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//New

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);//Runnable

        while (state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();
            System.out.println(state);
        }
        thread.start();//线程死亡以后就不能再次启动了
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("/////");
    }
}
