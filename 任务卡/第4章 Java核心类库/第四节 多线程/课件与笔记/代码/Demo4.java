package thread;


public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        //线程的休眠
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            Thread.sleep(1000);     //1000毫秒
        }
    }
}
