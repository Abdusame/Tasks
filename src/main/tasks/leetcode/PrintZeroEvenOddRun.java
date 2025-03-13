package tasks.leetcode;

import java.util.function.IntConsumer;

public class PrintZeroEvenOddRun {
    public static void main(String[] args) {
        PrintZeroEvenOdd zeroEvenOdd = new PrintZeroEvenOdd(9);
        IntConsumer p1 = new IntConsumer() {
            @Override
            public void accept(int i) {
                System.out.print(i);
            }
        };

        Thread s1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(p1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        Thread s2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(p1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        Thread s3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(p1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...      
                Thread.currentThread().interrupt();
            }
        });

        s1.start();
        s2.start();
        s3.start();

    }
}
