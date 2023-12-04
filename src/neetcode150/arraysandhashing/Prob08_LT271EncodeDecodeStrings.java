package neetcode150.arraysandhashing;

import java.util.*;

public class Prob08_LT271EncodeDecodeStrings {
    /*
    Design an algorithm to encode a list of strings to a string.
    The encoded string is then to be decoded

    idea is to generate length#string for each string and create one full string
     */

    public static final char DELIMITER = '#';

    // Encodes a list of strings to a single string
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings
    public static List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();

        // loop through the array
        for (int i = 0; i < arr.length; i++) {
            // find the number of chars
            StringBuilder sb = new StringBuilder();
            while(arr[i] != DELIMITER) {
                sb.append(arr[i++]);
            }
            // skip delimiter
            i++;
            // now sb will have the length number as char
            int currLength = Integer.valueOf(sb.toString());
            //calculate the end
            int end = i + currLength;
            sb = new StringBuilder();

            // add the chars to the sb
            while(i < end) {
                sb.append(arr[i++]);
            }
            i--;
            // add the current string to the result
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> source =new LinkedList<>();
        source.add("Hello");
        source.add("World");

        String encoded = encode(source);
        System.out.println(encoded);

        List<String> decoded = decode(encoded);
        System.out.println(decoded);
    }
}
