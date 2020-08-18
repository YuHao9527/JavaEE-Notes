package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo15 {
    /*单线程线程池
    执行流程
        1 判断线程池的那个线程是否空闲
        2 空闲则使用
        3 不空闲则等待它空闲后再使用
    **/
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
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
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
            }
        });
    }
}
