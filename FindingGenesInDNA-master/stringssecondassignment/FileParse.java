/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringssecondassignment;

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
    private String fileName ;
    private ArrayList<String> listOfStrings = new ArrayList<String>();
    FileParse(String fn){
        fileName = fn ;
         
    }
    public ArrayList<String> ReadLineByLine(){
        
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                String tmp = sc.nextLine();
                
                listOfStrings.add(tmp);
                
            }
           
        
        }catch(IOException e){
            e.printStackTrace();
            
        }
        return listOfStrings;
    }
}
