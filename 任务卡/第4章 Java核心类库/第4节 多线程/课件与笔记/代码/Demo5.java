package thread;


public class Demo5 {
    public static void main(String[] args) {
        //线程中断
        //y一个线程是一个独立的执行路径，它是否结束应该由其自身决定
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //给线程t1添加中断标记
        t1.interrupt();
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    System.out.println("发现了中断标记，线程自杀");
                    return;
                }
            }
        }
    }
}
