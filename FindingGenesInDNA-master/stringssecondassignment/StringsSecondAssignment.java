/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringssecondassignment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onur
 */
public class StringsSecondAssignment {

    /**
     * @param args the command line arguments
     */
    public int findTheSmallestAmongThree(int x,int y,int z){
        //The dna might not have all of the stop codon, which will result in -1
        //    
        List<Integer> posNumber = new ArrayList<Integer>();
        
        if(x>0){
            posNumber.add(x);
        }
        if(y>0){
            posNumber.add(y);
        }
        if(z>0){
            posNumber.add(z);
        }
        
        int smallest = posNumber.get(0);
        for(int i=1; i< posNumber.size();i++){
            if(posNumber.get(i) < smallest){
                smallest =posNumber.get(i); 
            }
        
        }
        return smallest;
        
    }
    public double cgRatio(String dna){
       double sizeOfDna = dna.length();
       int count =0;
       for (int i =0; i < sizeOfDna;i++){
           if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
               count+=1;
           }
       
       }
       return count/sizeOfDna;
    
    } 
    public int countCTG(String dna){
        int count = 0 ;
        int index = dna.indexOf("CTG");
        while(index !=-1){
            count++;
            index = dna.indexOf("CTG",index+1);
            
        
        }
        return count;
    
    }
    public void processGenes(List<String> sr){
        int howManyLonger =0;
        int howManyCG=0;
        
        System.out.println("The strings longer than length 9:");
        for (int i=0; i< sr.size();i++){
            if(sr.get(i).length() >60){
                howManyLonger++;
                System.out.println(sr.get(i));
            }
        
        }
        System.out.println("There are " + howManyLonger + " string whose length is longer than 9");
        for (int i=0; i< sr.size();i++){
            if( cgRatio(sr.get(i))> 0.35){
                howManyCG++;
                System.out.println(sr.get(i));
            }
        
        }
        System.out.println("There are " + howManyCG + "whose C-G-ratio is higher than 0.35 ");
        
        
    
    }
    public int howMany(String a, String b){
        
        int index = b.indexOf(a);
        int count =0;
        while(index!=-1){
            count++;
            index = b.indexOf(a,index+1);
        }
        return count;
    }
    public int countGenes(String dna){
        return findGene(dna).size();
    
    }
    
    public int findStopIndex(String dna, int startIndex, String codon){
        //TAA , TGA , TAG
        int stopIndex = dna.indexOf(codon,startIndex);
        int difference = 1;
        while (stopIndex != -1){
            difference = stopIndex - startIndex;
            if(difference %3 ==0){
                return stopIndex;
            
            }
            else {
                stopIndex = dna.indexOf(codon,stopIndex+1);
            
            }
        
        }
        return stopIndex;
       
    
    }
    
    public ArrayList<String> findGene(String dna){
        ArrayList<String> allGenes = new ArrayList<String>();
        // We should find a stop codon 
        if(dna.indexOf("TAA") ==-1 && dna.indexOf("TGA")==-1 && dna.indexOf("TAG")==-1){ 
            return allGenes;
        }
        
        String result = "";
        boolean flag = true;
        int indexStart = dna.indexOf("ATG");
        //we should have a start codon 
        while(indexStart != -1  ){
            if (findStopIndex(dna,indexStart,"TAA")==-1 &&findStopIndex(dna,indexStart,"TAG")==-1 &&findStopIndex(dna,indexStart,"TGA")==-1){
                break;
            
            }
            else {
                int tmp = findTheSmallestAmongThree(findStopIndex(dna,indexStart,"TAA"),findStopIndex(dna,indexStart,"TAG"),findStopIndex(dna,indexStart,"TGA"));
                allGenes.add(dna.substring(indexStart, tmp+3));
                indexStart = dna.indexOf("ATG",tmp+1);
            
            }
            
            
        
        }
        
         
       
        return allGenes;
        
    
    }
    public void testFindGene(){
        
        
        FileParse fileParse = new FileParse("brca1line.fa");
        ArrayList<String> allStrings = fileParse.ReadLineByLine();
        //System.out.println(allStrings.get(0).toUpperCase());
        int countLongerThan = 0;
        int count2 =0;
        //System.out.println(findGene(allStrings.get(0).toUpperCase()).size());
        for (int i=0; i<findGene(allStrings.get(0).toUpperCase()).size();i++ ){
            if(findGene(allStrings.get(0).toUpperCase()).get(i).length()>60){
                countLongerThan++;
            }
            if(cgRatio(findGene(allStrings.get(0).toUpperCase()).get(i)) > 0.35){
                count2++;
            
            }
        
        } 
        
        //System.out.println("Longer than 60 :" + countLongerThan);
        //System.out.println("Greater than 0.35:" + count2);
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
        System.out.println(findGene("AATGCTAACTAGCTGACTAAT"));
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello!");
        StringsSecondAssignment sa = new StringsSecondAssignment();
        sa.testFindGene();
        
        
        
    }
    
}
