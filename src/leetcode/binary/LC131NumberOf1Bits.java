package leetcode.binary;

public class LC131NumberOf1Bits {
    public static int numberOfBits(int n) {
        // Time complexity: O(1)
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if((mask & n) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("number of 1 bits in 9 is: " + numberOfBits(9) );
    }
}
