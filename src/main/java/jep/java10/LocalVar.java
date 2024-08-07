package jep.java10;

/**
 * Reference for JEP 286
 * https://openjdk.org/jeps/286
 */
public class LocalVar {

    public static void main(String[] args) {

        /*
         * The old way of writing, which require variable to be constructed with
         * exact type.
         */
        final String personName = "Andy";
        System.out.println("Hello " + personName);


        /*
         * Upon Java 10, there is no need to explicitly specify the type during variable
         * declaration, as Java is smart enough to infer that from the variable assignment.
         */
        final var newPersonName = "HF";
        System.out.println("Hello " + newPersonName);

        /*
         * However this feature will only work for concrete variable assignment,
         * and in the real world, it's not uncommon to see the following.
         *
         * In this case `var` is not applicable, because Java is a static type system
         * and JVM need to know the exact to perform type checking.
         *
         */
        String nameToPick = null;
        // Some logic to determine the name (1)
        // methodA(xxx)
        nameToPick = "A";
        // Some logic to determine the name (2)
        // methodB(xxx)
        nameToPick = "B";
        System.out.println("Hello " + nameToPick);







    }
}
