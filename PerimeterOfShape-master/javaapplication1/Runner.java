/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onur
 */
public class Runner {
    public static void main(String[] args){
    
        List<Point> listOfPoints ;
        
        FileParse fileParse = new FileParse("datatest1.txt");
        listOfPoints = fileParse.ReadLineByLine();
        Shape shape2= new Shape(listOfPoints);
        
        shape2.showShape();
        System.out.println(shape2.FindPerimeter(shape2));
        System.out.println("Average: "+shape2.getAverageLength(shape2));
        System.out.println("Largest side: "+shape2.getLargestSide(shape2));
        System.out.println("Largest X: "+shape2.getLargestX(shape2));
        System.out.println(shape2.getLargestPerimeterMultipleFiles());
        System.out.println(shape2.getFileWithLargestPerimeter());

        
        
        
    
   
    
    
    }
}
