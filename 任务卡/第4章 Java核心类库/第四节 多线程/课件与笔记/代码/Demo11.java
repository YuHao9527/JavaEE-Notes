package thread;


public class Demo11 {
    public static void main(String[] args) {
        //线程死锁
        Culprit c = new Culprit();
        Police p = new Police();
        new MyThread(c,p).start();
        c.say(p);
    }

    static class MyThread extends Thread{
        private Culprit c;
        private Police p;
        MyThread(Culprit c,Police p){
            this.c = c;
            this.p = p;
        }

        @Override
        public void run() {
            p.say(c);
        }
    }
    static class Culprit{
        public synchronized void say(Police p){
            System.out.println("罪犯：你放了我，我放了人质");
            p.fun();
        }
        public synchronized void fun(){
            System.out.println("罪犯被放了，罪犯也放了人质");
        }
    }
    static class Police{
        public synchronized void say(Culprit c){
            System.out.println("警察：你放了人质，我放了你");
            c.fun();
        }
        public synchronized void fun(){
            System.out.println("警察救了人质，但是罪犯跑了");
        }
    }
}
