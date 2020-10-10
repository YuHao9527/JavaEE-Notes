package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//同步代码块和同步方法都属于隐式锁
//线程同步lock

public class Demo10 {
    public static void main(String[] args) {
        Object o = new Object();
        //线程不安全
        //解决方案1   显示锁  Lock  子类 ReentrantLock

        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable{
        //总票数
        private int count = 10;
        //参数为true表示公平锁    默认是false 不是公平锁
        private Lock l = new ReentrantLock(true);
        @Override
        public void run() {
            while (true) {
                l.lock();
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
                    l.unlock();
            }
        }
    }
}
