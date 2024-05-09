package thirdParty.guava;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterExample {
    private static final RateLimiter rateLimiter = RateLimiter.create(5.0); // 5 requests per second

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (rateLimiter.tryAcquire()) {
                System.out.println("Request processed: " + i);
            } else {
                System.out.println("Request denied: " + i);
            }
        }
    }
}
