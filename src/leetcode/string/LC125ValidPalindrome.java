package leetcode.string;

public class LC125ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int p1=0, p2 = s.length()-1;

        while(p1 <= p2) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);

            if(Character.isLetterOrDigit(c1) == false) p1++;
            else if(Character.isLetterOrDigit(c2) == false) p2--;
            else {
                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                p1++; p2--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
