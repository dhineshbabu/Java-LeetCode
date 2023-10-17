package leetcode.binary;

public class LC131ReverseBits {
    public static int reverseBits(int n){
        // Time complexity: O(1)
        int reverse = 0;

        for(int i=1; i<=32; i++) {
            reverse = reverse << 1;
            reverse = reverse | (1 & n);
            n = n >> 1;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println("Decimal Representation of Reversed bits is: " + reverseBits(9) );
    }
}
