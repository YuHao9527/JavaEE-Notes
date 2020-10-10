package thread;



/*
实现Runnable与继承Thread相比有如下优势
1.通过创建任务，然后给线程分配任务的方式实现多线程，更适合多个线程同时执行任务的情况
2，可以避免单继承所带来的局限性
3，任务与线程是分离的，提高了程序的健壮性
4，后期学习的线程池技术，接受Runnable类型的任务，不接受Thread类型的线程
**/
public class Demo1 {
    public static void main(String[] args) {

        /*MyThread m = new MyThread();
        m.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("汗滴禾下土"+i);
        }*/
        //实现runnable
        //1 创建一个任务对象
        MyRunnable r = new MyRunnable();
        //创建一个线程并给他一个任务
        Thread t = new Thread(r);
        //启动线程
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("汗滴禾下土"+i);
        }
    }
}

