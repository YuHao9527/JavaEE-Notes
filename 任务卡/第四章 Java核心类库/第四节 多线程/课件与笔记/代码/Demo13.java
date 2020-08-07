package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo13 {
    public static void main(String[] args) {
        //线程池
        //创建线程
        //创建任务
        //执行任务
        //关闭线程

        //缓存线程池
        //无限制长度
        //任务加入后的执行流程
        //1判断线程池是否存在空闲线程  2存在则使用   3不存在则创建线程并使用

        //向线程池中加入新的任务
        ExecutorService service = Executors.newCachedThreadPool();
        //指挥线程池执行新的任务
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
            }

        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
            }

        });service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
            }

        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
