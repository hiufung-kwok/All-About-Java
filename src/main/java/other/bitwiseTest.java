package other;

public class bitwiseTest {

    public static void main(String[] args) {

        int resultAnd = 5 & 3;
        // 0101 & 0011 ==  0001
        System.out.println(resultAnd);

        int resultOr = 5 | 3;
        // 0101 | 0011 == 0111 == 7
        System.out.println(resultOr);

        int resultXor = 5 ^ 3;
        // 0101 ^ 0011 == 0110 == 6
        System.out.println(resultXor);

        int resultLeftShift = 5 << 2;
        // 0101 << 2 == 10100 == 20
        System.out.println(resultLeftShift);

        int resultRightShift = 5 >> 2;
        // 0101 >> 2 == 0001 == 1
        System.out.println(resultRightShift);

        int resultUnsignedRightShift = 5 >> 2;
        // 0101 >>> 2 == 0001 == 1
        System.out.println(resultUnsignedRightShift);

        // Check whether number is even or not
        System.out.println("5 is odd: " + ((5 & 1) == 1) );
        System.out.println("5 is even: " + ((5 & 1) == 0) );

        // Clear the third bit
        System.out.println(100 & ~(1 << 2));

        // Set a specific bit to 1.
        System.out.println(8 | (1 << 2));

        // Toggle a given bit
        System.out.println(100 ^ (1 << 2));




    }

    /**
     * Swap two numbers with XOR.
     * @param a
     * @param b
     */
    private void swap (int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ", b = " + b);
    }

    /**
     * Count the bit of 1.
     * @param n
     * @return
     */
    int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

}
