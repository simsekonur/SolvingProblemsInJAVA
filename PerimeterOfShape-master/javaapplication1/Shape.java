/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onur
 */
public class Shape {

    private int sizeOfShape;

    private List<Point> listOfPoints = new ArrayList<Point>();

    public Shape() {
        sizeOfShape = 0;
    }

    public Shape(List<Point> listOfPoints2) {
        for (int i = 0; i < listOfPoints2.size(); i++) {

            this.addPointToShape(listOfPoints2.get(i));

        }

    }

    public void addPointToShape(Point p) {
        listOfPoints.add(p);
        sizeOfShape += 1;

    }

    public void showShape() {
        for (int i = 0; i < listOfPoints.size(); i++) {
            listOfPoints.get(i).showPoint();

        }

    }

    //We will calculate the perimeter on the condition that 
    //p1 is connected to p2 and p2 is connected to p3...
    public double FindPerimeter(Shape s) {
        double totalPerimeter = 0;
        //s.listOfPoints[0]--> first point
        //s.listOfPoints[s.sizeOfShape-1]
        int i = 0;

        while (i < s.sizeOfShape - 1) {
            totalPerimeter += s.listOfPoints.get(i).FindDistanceBetweenPoints(s.listOfPoints.get(i + 1));
            i++;

        }
        totalPerimeter += s.listOfPoints.get(0).FindDistanceBetweenPoints(s.listOfPoints.get(s.sizeOfShape - 1));

        return totalPerimeter;

    }

    public double getAverageLength(Shape s) {

        return s.FindPerimeter(s) / s.sizeOfShape;
    }

    public double getLargestSide(Shape s) {
        double largest = 0;
        int i = 0;
        while (i < s.sizeOfShape - 1) {
            if (s.listOfPoints.get(i).FindDistanceBetweenPoints(s.listOfPoints.get(i + 1)) > largest) {
                largest = s.listOfPoints.get(i).FindDistanceBetweenPoints(s.listOfPoints.get(i + 1));
            }
            i++;
        }
        if (s.listOfPoints.get(0).FindDistanceBetweenPoints(s.listOfPoints.get(s.sizeOfShape - 1)) > largest) {
            largest = s.listOfPoints.get(0).FindDistanceBetweenPoints(s.listOfPoints.get(s.sizeOfShape - 1));
        }

        return largest;
    }

    public double getLargestX(Shape s) {
        int max = 0;
        for (int i = 0; i < s.sizeOfShape; i++) {
            if (s.listOfPoints.get(i).getX() > max) {
                max = s.listOfPoints.get(i).getX();

            }

        }
        return ((double) (max));
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        List<String> listOfFiles = new ArrayList<String>();
        listOfFiles.add("datatest1.txt");
        listOfFiles.add("datatest2.txt");
        listOfFiles.add("datatest3.txt");
        listOfFiles.add("datatest4.txt");
        listOfFiles.add("datatest5.txt");
        listOfFiles.add("datatest6.txt");
        // listOfFiles.add("example1.txt");
        // listOfFiles.add("example2.txt");
        //listOfFiles.add("example3.txt");
        //listOfFiles.add("example4.txt");

        double max = 0;
        for (int i = 0; i < listOfFiles.size(); i++) {
            FileParse fileParse = new FileParse(listOfFiles.get(i));
            listOfPoints = fileParse.ReadLineByLine();
            Shape s = new Shape(listOfPoints);

            if (s.FindPerimeter(s) > max) {
                max = s.FindPerimeter(s);
            }
        }
        return max;

    }

    public String getFileWithLargestPerimeter() {
        List<String> listOfFiles = new ArrayList<String>();
        //listOfFiles.add("datatest1.txt");
        //listOfFiles.add("datatest2.txt");
        //listOfFiles.add("datatest3.txt");
        //listOfFiles.add("datatest4.txt");
        //listOfFiles.add("datatest5.txt");
        //listOfFiles.add("datatest6.txt");
        listOfFiles.add("example1.txt");
        listOfFiles.add("example2.txt");
        listOfFiles.add("example3.txt");
        listOfFiles.add("example4.txt");

        double max = 0;
        int index = 0;
        for (int i = 0; i < listOfFiles.size(); i++) {
            FileParse fileParse = new FileParse(listOfFiles.get(i));
            listOfPoints = fileParse.ReadLineByLine();
            Shape s = new Shape(listOfPoints);

            if (s.FindPerimeter(s) > max) {
                max = s.FindPerimeter(s);
                index = i;
            }
        }
        return listOfFiles.get(index);

    }

}
