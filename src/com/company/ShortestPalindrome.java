package com.company;

/**
 * Created by tnkhang on 6/20/2017.
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        // check is palindrome abd
        String next = "babd";
        boolean isPalindrome = checkPalindrome(next);
        int count = next.length()-1;
        // create characters list
        if(isPalindrome) {
            System.out.println("Already is palindrome");
        } else {
            while(count > 0) {
                String newString = next.charAt(count) + next;
                if(checkPalindrome(newString)) {
                    System.out.println(newString);
                }
                count--;
            }
        }
    }

    private static boolean checkPalindrome(String next) {
        StringBuilder stringBuilder = new StringBuilder(next);
        String strReverse = stringBuilder.reverse().toString();
        return strReverse.equals(next);
    }
}
