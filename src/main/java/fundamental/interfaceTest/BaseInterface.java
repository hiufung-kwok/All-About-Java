package fundamental.interfaceTest;

public interface BaseInterface {

    public void someBasicMethod ();

    /**
     * Default method can call other method within the interface,
     * because this is a instance method, whenever this method got called.
     * The invocation of someBasicMethod( ) is guarantee to be valid.
     */
    default void methodToPrint () {
        someBasicMethod();
        System.out.println("Hello from default implementation");
    }

    /**
     * Static method, called with BaseInterface.staticMethod();
     */
    static void staticMethod() {
        System.out.println("Hello from static method");
    }
}
