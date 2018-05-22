package demo.concurrent.thread;

class UserDaemonThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        //mt.setDaemon(true);
        mt.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println("Daemon is " + isDaemon());
            while (true) ;
        }
    }
}

