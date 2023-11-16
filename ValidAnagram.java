/*
Problem: 242. Valid Anagram

Description: Given two strings s and t, return true if t is an anagram of s, and false otherwise. An Anagram is a word
or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters
exactly once.

 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> letters = new HashMap<>();

        for(char letter : s.toCharArray()) {
            if(letters.containsKey(letter)) {
                int newValue = letters.get(letter) + 1;
                letters.replace(letter, newValue);
            } else {
                letters.put(letter, 1);
            }
        }

        for(char letter : t.toCharArray()) {
            if(!letters.containsKey(letter)) return false; // letters not in s
            else {
                int newValue = letters.get(letter) - 1;

                if(newValue == -1) return false;

                letters.replace(letter, newValue);
            }
        }

        return true;
    }
}
