package thread;



//线程同步synchronized

public class Demo9 {
    public static void main(String[] args) {
        Object o = new Object();
        //线程不安全
        //解决方案2  同步方法
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable{
        //总票数
        private int count = 10;
        @Override
        public void run() {

            while (true) {
                boolean flag = sale();
                if(!flag){
                    break;
                }
            }
        }
        public synchronized boolean sale(){
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
                return true;
            }
                return false;

        }
    }
}
