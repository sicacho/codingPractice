package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        String[] arrays = new String[5];
//        arrays[0] = "aa";
//        arrays[1] = "aab";
//        arrays[2] = "acca";
//        arrays[3] = "aa";
//        arrays[4] = "ccaa";
//        Stream.of(allLongestStrings(arrays)).forEach(System.out::println);
//        System.out.println(getSubStringWithoutDuplicate("bbbbbmnbvcx"));
    }
    static String[] allLongestStrings(String[] inputArray) {
        String[] result = null;
        int longestStringLength = 0 ;
        int countStrings = 0;
        for(int i = 0 ; i < inputArray.length ; i++) {
            if(inputArray[i].length() > longestStringLength) {
                longestStringLength = inputArray[i].length();
                result = new String[inputArray.length-i];
                result[i+result.length-inputArray.length] = inputArray[i];
                countStrings = 1;
            } else if(inputArray[i].length() == longestStringLength ) {
                result[i+result.length-inputArray.length] = inputArray[i];
                countStrings++;
            }
        }
        if(countStrings<result.length) {
            String[] resultTemp = new String[countStrings];
            int countTempIndex = 0;
            for (int i = 0; i < result.length; i++) {
                if(result[i]!=null) {
                    resultTemp[countTempIndex] = result[i];
                    countTempIndex++;
                }

            }
            result = resultTemp;
        }

        return result;
    }

    static int commonCharacterCount(String s1, String s2) {
        // create pair of char
        List<String> pairOfChars = buildPairOfChar(s1);
        int count = 0 ;
        for (String chars: pairOfChars) {
            if(s2.contains(chars)) {
                count++;
            }
        }
        return count;
    }

     static List<String> buildPairOfChar(String s1) {
        List<String> result = IntStream.of(s1.length()).mapToObj(value -> {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                if(i+value < s1.length()) {
                    strings.add(s1.substring(i,i+value));
                }
            }
            return strings;
        }).reduce((strings, strings2) -> {strings.addAll(strings2);return strings;}).get();
        return result;
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
