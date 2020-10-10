package thread;


public class Demo12 {
    public static void main(String[] args) {
        //多线程通信    生产者与消费者问题
        Food f = new Food();
        new Cook(f).start();
        new Waiter(f).start();
    }
    //厨师
    static class Cook extends Thread{
        private Food f;

        public Cook(Food f) {
            this.f = f;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if(i%2==0){
                    f.setNameAndTaste("老干妈小米粥","香辣味");
                }else {
                    f.setNameAndTaste("煎饼果子","甜辣味");
                }
            }
        }
    }
    //服务员
    static class Waiter extends Thread{
        private Food f;

        public Waiter(Food f) {
            this.f = f;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                f.get();
            }
        }
    }
    //食物
    static class Food{
        private String name;
        private String taste;
        //true表示可以生产
        boolean flag = true;
        public synchronized void setNameAndTaste(String name,String taste){
            if(flag){
                this.name = name;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.taste = taste;
                flag = false;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        public synchronized void get(){
            if(!flag){
                System.out.println("服务员端走的菜的名称是："+name+",味道是："+taste);
                flag = true;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
