package fundamental.oop.innerClass;

/**
 * Wrapped another class definition (Non-static),
 * require constructor before any method call.
 */
public class InnerClass {
    class NestedInnerClass {
        void display() {
            System.out.println("Inside non-static inner class");
        }
    }
}