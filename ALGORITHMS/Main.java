class KMP {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Empty needle matches at index 0
        }
        
        int[] lps = computeLPS(needle);
        int i = 0, j = 0;
        
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // Match found
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Move j to the previous longest proper prefix suffix
                } else {
                    i++; // Move i to the next character in haystack
                }
            }
        }
        
        return -1; // Match not found
    }
    
    // Function to compute the Longest Proper Prefix Suffix (LPS) array for the needle
    private int[] computeLPS(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0; // Length of the previous longest prefix suffix
        
        int i = 1;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}

public class Main {
    public static void main(String[] args) {
        KMP solution = new KMP();

        // Test cases
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Example 1:");
        System.out.println("Input: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\"");
        System.out.println("Output: " + solution.strStr(haystack1, needle1)); // Expected output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("\nExample 2:");
        System.out.println("Input: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\"");
        System.out.println("Output: " + solution.strStr(haystack2, needle2)); // Expected output: -1
    }
}
