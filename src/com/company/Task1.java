package com.company;

class Lucky {
    static StateInt value = new StateInt(0);
    static StateInt count = new StateInt(0);


    static class LuckyThread extends Thread {
        @Override
        public void run() {
            int x;
            while ((x = value.increment()) < 999999) {
                if ((x % 10) + (x / 10) % 10 + (x / 100) % 10 == (x / 1000)
                        % 10 + (x / 10000) % 10 + (x / 100000) % 10) {
                    System.out.println(x);
                    count.increment();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count.get());
    }
}