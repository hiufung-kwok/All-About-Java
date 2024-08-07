package fundamental.oop.innerClass;

/**
 * A class without a name, within a method.
 */
public class AnonymousOuterClass {
    void createAnonymousClass() {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void display() {
                System.out.println("Inside anonymous inner class");
            }
        };
        myInterface.display();
    }
}

interface MyInterface {
    void display();
}