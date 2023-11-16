/*
Problem: 1768. Merge Strings Alternately

Description: You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged
string. Return the merged string. If one of the words is longer, the letters left are appended to the end.

Constraints:
- 1 <= word1.length, word2.length <= 100
- word1 and word2 consist of lowercase English letters.
 */

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        /*
            LeetCode stats:
            - Runtime: 0ms (beats 100% of users with Java)
            - Memory: 40.50MB (beats 83.13% of users with Java)
         */
        int minLength = Math.min(word1.length(), word2.length());

        StringBuilder merged = new StringBuilder();
        for(int i=0; i<minLength; i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }

        String lettersLeft = "";
        if(word1.length() > word2.length()) {
            lettersLeft = word1.substring(minLength);
        } else if(word2.length() > word1.length()) {
            lettersLeft = word2.substring(minLength);
        }

        merged.append(lettersLeft);

        return merged.toString();
    }
}
