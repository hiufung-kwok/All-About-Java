package keyword.finalTest;

// Child class can't extend it.
final public class testFinalParentClass {

    // Child class can't override the definition.
    final void testComputation () {
        System.out.println("Computation");
    }
}
