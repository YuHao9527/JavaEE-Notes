package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Demo16 {
    /*周期任务  定长线程池
    执行流程
        1 判断线程池是否存在空闲线程
        2 存在则使用
        3 不存在空闲线程  且线程池未满的情况下  则创建线程  并放入线程池中  然后使用
        4 不存在空闲线程  且线程池已满的情况下  则等待线程池的空闲线程

        周期性任务执行时
                定时执行 当某个任务触发时  自动执行某任务
    **/
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        //定时执行一次
        //参数1：定时执行的任务
        //参数2：时长数字
        //参数3：2的时间单位    Timeunit的常量指定
       /* scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
            }
        },5, TimeUnit.SECONDS);      //5秒钟后执行*/

        /*
        周期性执行任务
            参数1：任务
            参数2：延迟时长数字（第一次在执行上面时间以后）
            参数3：周期时长数字（没隔多久执行一次）
            参数4：时长数字的单位
        * **/
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"锄禾日当午");
            }
        },5,1,TimeUnit.SECONDS);
    }
}
