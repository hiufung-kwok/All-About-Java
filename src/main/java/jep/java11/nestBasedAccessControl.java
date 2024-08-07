package jep.java11;

/**
 * This is more about how JVM internally handle calling private member,
 * from nested method.
 * Ref: https://openjdk.org/jeps/181
 * https://mkyong.com/java/java-11-nest-based-access-control/
 */
public class nestBasedAccessControl {

    private String name = "Andy";

    public class innerClassA {
        public void printMyName() {
            System.out.println(name);
        }
    }
}
