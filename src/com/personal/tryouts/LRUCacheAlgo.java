package com.personal.tryouts;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCacheAlgo {

    static int capacity = 4;
    static LinkedHashSet<Integer> cache = new LinkedHashSet<>(capacity);


    private static boolean get(int key) {
        if(!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }

    private static void refer(int key) {
        if(!get(key))
            put(key);

    }

    private static void put(int key) {
        if(cache.size() >= capacity) {
            // get the 1st element of cache which is least recently used.
            int firstElement = cache.iterator().next();
            cache.remove(firstElement);
        }
        cache.add(key);
    }

    private static void display() {
        LinkedList<Integer> linkedList = new LinkedList<>(cache);
        for (Iterator<Integer> it = linkedList.descendingIterator(); it.hasNext(); ) {
            Integer val = it.next();
            System.out.print(val + ", ");
        }
    }

    public static void main(String[] args) {
        LRUCacheAlgo lruCacheAlgo = new LRUCacheAlgo();
        refer(1);
        refer(2);
        refer(3);
        refer(1);
        refer(4);
        refer(5);
        display();
    }
}
