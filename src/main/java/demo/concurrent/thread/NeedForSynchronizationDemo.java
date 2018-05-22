package demo.concurrent.thread;

public class NeedForSynchronizationDemo {
    public static void main(String[] args) {
        FinTrans ft = new FinTrans();
        FinTrans ft2 = new FinTrans();
        TransThread tt1 = new TransThread(ft, "Deposit Thread");
        // No synchronization needed if pass ft2 instead
        TransThread tt2 = new TransThread(ft, "Withdrawal Thread");
        tt1.start();
        tt2.start();
    }

    static class FinTrans {
        public String transName;
        public double amount;
    }

    static class TransThread extends Thread {
        private FinTrans ft;

        TransThread(FinTrans ft, String name) {
            super(name); // Save thread's name
            this.ft = ft; // Save reference to financial transaction object
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                if (getName().equals("Deposit Thread")) {
                    // Start of deposit thread's critical code section
                    ft.transName = "Deposit";
                    try {
                        Thread.sleep((int) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                    }
                    ft.amount = 2000.0;
                    System.out.println(ft.transName + " " + ft.amount);
                    // End of deposit thread's critical code section
                } else {
                    // Start of withdrawal thread's critical code section
                    ft.transName = "Withdrawal";
                    try {
                        Thread.sleep((int) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                    }
                    ft.amount = 250.0;
                    System.out.println(ft.transName + " " + ft.amount);
                    // End of withdrawal thread's critical code section
                }
            }
        }
    }
}



