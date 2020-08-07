package thread;


public class Demo2 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("12345"+i);
                }
            }
        }.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("汗滴禾下土"+i);
        }
    }
}
