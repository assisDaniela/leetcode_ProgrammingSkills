/*
Problem: 459. Repeated Substring Pattern

Description: Given a string s, check if it can be constructed by taking a substring of it and appending multiple
copies of the substring together.

 */

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {

        for(int endIndex=0; endIndex<s.length()-1; endIndex++) {
            String sub = s.substring(0, endIndex+1);
            if(s.length() % sub.length() != 0) continue;

            int jump = sub.length();
            boolean findPattern = true;
            for(int j=endIndex+1; j<s.length(); j+=jump) {
                String possiblePattern = s.substring(j, j+jump);
                if(!possiblePattern.equals(sub)) {
                    findPattern = false;
                    break;
                }
            }

            if(findPattern) return true;
        }

        return false;
    }
}
