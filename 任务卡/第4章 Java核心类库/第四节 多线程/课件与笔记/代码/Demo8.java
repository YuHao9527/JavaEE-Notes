package thread;


//线程同步synchronized

public class Demo8 {
    public static void main(String[] args) {
        Object o = new Object();
        //线程不安全
        //解决方案1  同步代码块
        //格式：synchronized（锁对象）{
        //
        //
        //      }
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable{
        //总票数
        private int count = 10;
        private Object o = new Object();
        @Override
        public void run() {
            //Object o = new Object();    //这里不是同一把锁，所以锁不住
                while (true) {
                    synchronized (o) {
                        if (count > 0) {
                         //卖票
                            System.out.println("正在准备卖票");
                            try {
                            Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            e.printStackTrace();
                            }
                            count--;
                            System.out.println(Thread.currentThread().getName()+"卖票结束,余票：" + count);
                        }else {
                            break;
                        }

                }
            }
        }
    }
}
