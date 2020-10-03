/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsfirstassignments;

/**
 *
 * @author onur
 */
public class Part3 {
    public boolean twoOccurrences(String a, String b){
        boolean result = false;
        int index = b.indexOf(a);// index ->-1 or index 
        int index2= b.indexOf(a,index+1);
       
        if(index!=-1 && index2!=-1){//found more than one
            result = true ;
        }
        else {
            result = false;
        }
        
        return result ;
        
    
    
    }
    public void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        System.out.println(twoOccurrences("w", "banana"));
        System.out.println(lastPart("uke","dukeprogramming"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
    public String lastPart(String a, String b){
        String result = "";
        int index= b.indexOf(a);
        if (index ==-1){
            result = b;
        }
        else {
            index += a.length();
            result = b.substring(index);
        
        }
       
        return result ;
    
    }
    public static void main(String[] args){
        Part3 part3 = new Part3();
        part3.testing();
    
    }
    
}
