package designPattern.Singleton;


/**
 * This can save some memory, if there is no call to this singleton at all during
 * the whole life-cycle of the application.
 */
public class LazySingleton {

    private LazySingleton() {
    }

    public static LazySingleton lz = null;

    /**
     * Not thread, especially getInstance being called by multiple thread around the same time.
     * @return
     */
    public static LazySingleton getInstance() {
        if (lz == null) {
            lz = new LazySingleton();
        }
        return lz;
    }
}
