package jep.java14;

public class jep359Records {

    /**
     * Dummy record class, this is also a syntax sugar to eliminate the amount of
     * code required, for writing POJOs.
     *
     * This is more for maintenance purpose,but developer use IDE to
     * generate getter, setter and constructor anyway.
     *
     * @param id Dummy id.
     * @param password Dummy password.
     */
    public record User(int id, String password) {
        // Additional validation upon constructor.
        public User {
            if(id < 0) {
                throw new IllegalArgumentException("ID cannot be negative");
            }
        }
    };

    public static void main(String[] args) {

        var user1 = new User(99, "456");

        // With default toString method.
        System.out.println(user1);

    }
}
