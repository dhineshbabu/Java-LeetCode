package leetcode.binary;

import java.util.Arrays;

public class LC338CountingBits {
    public static int[] countBits(int num) {
        int[] output = new int[num+1];
        for(int i=1; i<output.length; i++) {
            output[i] = output[i >> 1] + i%2;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println("number of 1 bits in 9 is: " + Arrays.toString(countBits(9) ));
    }
}
