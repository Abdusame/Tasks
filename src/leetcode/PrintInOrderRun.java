package leetcode;

public class PrintInOrderRun {
    public static void main(String[] args) {
        PrintInOrder pio = new PrintInOrder();
        Runnable t1 = new Thread(() -> System.out.print("first"));
        Runnable t2 = new Thread(() -> System.out.print("second"));
        Runnable t3 = new Thread(() -> System.out.print("third"));

        Thread s1 = new Thread(() -> {
            try {
                pio.second(t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        Thread s2 = new Thread(() -> {
            try {
                pio.first(t1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        Thread s3 = new Thread(() -> {
            try {
                pio.third(t3);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        s3.start();
        s1.start();
        s2.start();
    }
}
