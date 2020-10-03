/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author onur
 */
public class FileParse {
    private String fileName;
    private List<Point> listOfPoints = new ArrayList<Point>();
    FileParse(String fn){
        fileName = fn ;
    
    }
    public List<Point> ReadLineByLine(){
        
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                String tmp = sc.nextLine();
                
                Point p1 = new Point(Integer.parseInt(tmp.split(",")[0]),Integer.parseInt(tmp.split(",")[1]));
                listOfPoints.add(p1);
                
            
            }
           
        
        }catch(IOException e){
            e.printStackTrace();
            
        }
        return listOfPoints;
    }
    
    
}
