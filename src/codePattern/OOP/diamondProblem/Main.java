package codePattern.OOP.diamondProblem;

interface A {
    default void greet() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void greet() {
        System.out.println("Hello from B");
    }
}

/**
 * When it overrides, it overrides both greet method, no matter the object got casted to A or B.
 */
class MyClass implements A, B {
    // Override the greet() method to provide a custom implementation
    @Override
    public void greet() {
        // Choose which default method implementation to use
        A.super.greet(); // Choose implementation from interface A
        // B.super.greet(); // Alternatively, choose implementation from interface B
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.greet(); // Output: Hello from A

        // What if I pick explicitly for Interface B?
        B b = new MyClass();
        b.greet();
    }
}
