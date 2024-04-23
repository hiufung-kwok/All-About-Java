package designPattern.singleton;

/**
 * Ref: https://juejin.cn/post/7337205293775061032
 */
public class ThreadSafeSingleton {

    /**
     * Because the instance creation happen during the initialization, hence it's thread safe.
     * However, this may result in memory waste, as the instance will be created even there is no call to this at all.
     */
    public static final ThreadSafeSingleton SINGLETON_INSTANCE = new ThreadSafeSingleton();

    /**
     * Scoped as private to make sure not external invoke.
     */
    private ThreadSafeSingleton() {

    }

    /**
     * No matter how many times got called, only single instance being returned.
     * @return
     */
    public static ThreadSafeSingleton getInstance() {
        return SINGLETON_INSTANCE;
    }
}
