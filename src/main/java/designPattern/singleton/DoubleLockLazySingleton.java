package designPattern.singleton;

public class DoubleLockLazySingleton {

    private volatile static DoubleLockLazySingleton dls = null;

    /**
     * Why the second null check is needed, because in the case of 2 threads accessing the
     * same method, after the first thread exit the sync block and with dls filled with ref,
     * the second won't aware of this, and the first thing after it gain access to the sync block,
     * is to execute `dls = new DoubleLockLazySingleton();` hence the second null check is required.
     * @return
     */
    public static DoubleLockLazySingleton getInstance() {
        if (dls == null) {
            synchronized (DoubleLockLazySingleton.class) {
                if (dls == null) {
                    dls = new DoubleLockLazySingleton();
                }
            }
        }
        return dls;
    }
}
