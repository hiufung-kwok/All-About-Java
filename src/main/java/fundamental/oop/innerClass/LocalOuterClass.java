package fundamental.oop.innerClass;

/**
 * Class defined within the method.
 */
public class LocalOuterClass {
    void myMethod() {
        class LocalInnerClass {
            void display() {
                System.out.println("Inside local inner class");
            }
        }
        LocalInnerClass lic = new LocalInnerClass();
        lic.display();
    }
}