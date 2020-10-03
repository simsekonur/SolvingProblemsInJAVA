/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author onur
 */
public class Point {

    /**
     * @param args the command line arguments
     */
    private int x;
    private int y;

    public Point(int x1, int y1) {
        x = x1;
        y = y1;
    }

    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");

    }

    public double FindDistanceBetweenPoints(Point p2) {
        double dx = (x - p2.x) * (x - p2.x);
        double dy = (y - p2.y) * (y - p2.y);
        return Math.sqrt(dx + dy);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
