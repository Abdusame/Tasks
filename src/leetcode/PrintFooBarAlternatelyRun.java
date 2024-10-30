package leetcode;

public class PrintFooBarAlternatelyRun {
    public static void main(String[] args) {
        PrintFooBarAlternately pfba = new PrintFooBarAlternately(100);
        Runnable t1 = new Thread(() -> System.out.print("foo"));
        Runnable t2 = new Thread(() -> System.out.print("bar"));

        Thread s1 = new Thread(() -> {
            try {
                pfba.foo(t1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        Thread s2 = new Thread(() -> {
            try {
                pfba.bar(t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        s2.start();
        s1.start();
    }
}
