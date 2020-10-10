package thread;


public class Demo7 {
    public static void main(String[] args) {
        //线程不安全
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
            while (count>0){
                //卖票
                System.out.println("正在准备卖票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("卖票结束,余票："+count);
            }
        }
    }
}
