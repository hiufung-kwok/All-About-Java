package designPattern.Singleton;

public class SyncLazySingleton {

    private static SyncLazySingleton slz = null;

    /**
     * Sure, by wrapping the whole method with keyword synchronized will garantee
     * only once thread enter this method at any given time.
     * However, by doing so all other threads will be turned from Running to Monitor state,
     * and this will cause performance issue.
     * @return
     */
    public synchronized static SyncLazySingleton getInstance() {
        if (slz == null) {
            slz = new SyncLazySingleton();
        }
        return slz;
    }
}
