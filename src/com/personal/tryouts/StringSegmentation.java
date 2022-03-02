package com.personal.tryouts;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {

    public static void main(String[] args) {
        String s = "hellonnow";

        Set<String> dictionary = new HashSet<>();
        dictionary.add("hello");
        dictionary.add("hell");
        dictionary.add("on");
        dictionary.add("now");

        boolean canbeSegmented = new StringSegmentation().canSegmented(s, dictionary);

        System.out.println(canbeSegmented);


    }

    private boolean canSegmented(String s, Set<String> dictionary) {
        for(int i=0; i< s.length(); i++) {
            String first = s.substring(0, i);
            if(dictionary.contains(first)) {
                String second = s.substring(i);
                if(second == null || second.isEmpty() || dictionary.contains(second) || canSegmented(second, dictionary))
                    return true;
            }
        }

        return false;
    }
}
