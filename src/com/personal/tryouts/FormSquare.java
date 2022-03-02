package com.personal.tryouts;

import java.util.ArrayList;
import java.util.List;

/**
 * WIP Solution, Not ready Yet, Please do not refer this program.
 */
public class FormSquare {

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(10,10));
        list.add(new Point(10,20));
        list.add(new Point(20,10));
        System.out.println(canFormASquare(list, new Point(20,20)));
    }

    static class Point {

        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

// implement hashcode and equals follows
    }


    static boolean canFormASquare(List<Point> listPoints, Point pair) {

        if(listPoints == null || listPoints.size() == 0) {
            return false;
        }

        int count = 0;
        for(int i=0; i< listPoints.size(); i++) {
            Point point = listPoints.get(i);
            if(point != null) {
                int l = point.x - pair.x;
                int b = point.y - pair.y;
                if(l == b){
                    count++;
                }
            }
        }

        if(count == listPoints.size()) {

            return true;
        }

        return false;


    }


}

