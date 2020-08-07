package thread;


public class MyThread extends Thread {

    //run方法就是线程要执行的任务方法

    @Override
    public void run() {
        //这里的代码就是一条新的执行路径
        //这个执行路径是触发方式，不是调用run方法，而是通过thread对象的start方法来启动任务
        for (int i = 0; i < 10; i++) {
            System.out.println("锄禾日当午"+i);
        }
    }
}
