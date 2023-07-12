package com.personal.tryouts;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "teeter";
        printFirstNonRepeatingCharacterFromString(s);
    }

    private static void printFirstNonRepeatingCharacterFromString(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for(int i=0; i<= arr.length-1; i++) {
            if(charMap.containsKey(arr[i])) {
                int count = charMap.get(arr[i]);
                charMap.put(arr[i], ++count);
            } else {
                charMap.put(arr[i], 1);
            }
        }
        for(char c: charMap.keySet()) {
            if(charMap.get(c) == 1) {
                System.out.println(c);
                return;
            }
        }
    }
}
