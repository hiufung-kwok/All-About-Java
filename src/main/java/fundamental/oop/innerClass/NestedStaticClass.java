package fundamental.oop.innerClass;


/**
 * A static class wrapped inside a normal class.
 */
public class NestedStaticClass {

    static class NestClass {
        void display() {
            System.out.println("Inside static nested class");
        }
    }
}