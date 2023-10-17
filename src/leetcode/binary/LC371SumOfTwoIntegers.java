package leetcode.binary;

public class LC371SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        // TIme complexity: O(32) (i.e) O(1)
        while(b != 0) {
            int carry = a&b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("the sum is : " + getSum(3,18));
    }
}
