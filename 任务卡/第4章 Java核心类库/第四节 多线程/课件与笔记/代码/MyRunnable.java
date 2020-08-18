package thread;


public class MyRunnable implements Runnable{
    @Override
    public void run() {
        //线程的任务
        for (int i = 0; i < 10; i++) {
            System.out.println("锄禾日当午"+i);
        }
    }
}
