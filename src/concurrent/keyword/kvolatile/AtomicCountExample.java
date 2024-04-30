package concurrent.keyword.kvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCountExample {
    private   static final AtomicInteger sum = new AtomicInteger(0);
    public static  void increment(){
        // The order still won't be guaranteed, but at least each number will only be printed for once.
        final int result = sum.getAndIncrement();
        System.out.println(result);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 2 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 100 ; j++) {
                    increment();
                    // The below count won't be accurate, especially in the case of
                    // multiple threads execution.
//                    System.out.println(sum);
                }
            }).start();
        }
    }

}
