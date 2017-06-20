package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(getSubStringWithoutDuplicate("bbbbbmnbvcx"));
    }

    static int getSubStringWithoutDuplicate(String next) {
        // maximum subString length next.length
        int longestLength = 0;
        for(int i = 0 ; i < next.length() ; i++) {
            // get all SubString
            for (int beginIndex = 0; beginIndex < next.length(); beginIndex++) {
                int endIndex = beginIndex + i;
                if(endIndex <=next.length()) {
                    String subString = next.substring(beginIndex, endIndex);
                    if(!checkSubStringIsDuplicate(subString)) {
                        int length = subString.length();
                        if(length > longestLength) {
                            longestLength = length;
                        }
                    }
                }
            }
        }
        // check subString is not duplicate character
        // get the longest subString
        return longestLength;
    }

    private static boolean checkSubStringIsDuplicate(String subString) {
        boolean[] booleans = new boolean[256];
        for (int i = 0; i < subString.length(); i++) {
            int charInt = subString.charAt(i);
            if(booleans[charInt]) return true;
            booleans[charInt]=true;
        }
        return false;
    }
}
