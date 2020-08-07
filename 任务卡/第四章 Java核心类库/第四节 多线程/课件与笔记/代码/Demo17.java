package thread;


public class Demo17 {
    /*
    lambda表达式
    函数式编程思想
    **/
    public static void main(String[] args) {
        //冗余的Runnable编写方式
       /* Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("锄禾日当午");
            }
        });
        t.start();*/

        Thread t = new Thread(() -> System.out.println("锄禾日当午"));
        t.start();
    }


}
