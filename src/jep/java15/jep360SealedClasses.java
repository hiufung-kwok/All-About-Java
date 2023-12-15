package jep.java15;

/**
 * Aim to provide restriction and control over the inheritance.
 *
 * Classes that extended from the sealed must has one of the below identifier:
 *  - final, non-sealed, sealed.
 *
 * Ref: https://www.baeldung.com/java-15-new
 */
public class jep360SealedClasses {

    public abstract sealed class Person
            permits Employee, Manager { }
    public final class Employee extends Person { }

    public non-sealed class Manager extends Person { }

}
