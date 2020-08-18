package thread;


public class Demo3 {
    public static void main(String[] args) {
        //如何获取线程的名称
        System.out.println(Thread.currentThread().getName());
        //两种设置线程名称的方式
        Thread t = new Thread(new MyRunnable());
        t.setName("wwww");
        t.start();
        new Thread(new MyRunnable(),"锄禾日当午").start();
        //不设置的有默认的名字
        new Thread(new MyRunnable()).start();
    }
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
