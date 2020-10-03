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
public class Part1 {
    public String findSimpleGene(String dna){
        int difference = 0;
        String gene = "";
        //start code ATG 
        //stop code  TAA
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex);
        difference = stopIndex -(startIndex+3);
        if (startIndex !=-1 && stopIndex!=-1 &&((difference % 3)==0)){ // have start codon, stop codon
            
            gene = dna.substring(startIndex, stopIndex+3);
        }
       
        return gene;
        
    
    }
    public void testSimpleGene(){
        String dna1 = "AGATGCGATACGCTTAATC";
        String dna2 = "AGATGCGATACGCTAATC";
        String dna3 = "CTTTTG";
        String dna4 = "CTATGTATCGATTG";
        System.out.println("The dna1 is: "+ dna1);
        System.out.println("The gene in DNA1: "+findSimpleGene(dna1));
        System.out.println("The dna2 is: "+ dna2);
        System.out.println("The gene in DNA2: "+findSimpleGene(dna2));
        System.out.println("The dna3 is: "+ dna3);        
        System.out.println("The gene in DNA3: "+findSimpleGene(dna3));
        System.out.println("The dna4 is: "+ dna4);        
        System.out.println("The gene in DNA4: "+findSimpleGene(dna4));
    
    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Part1 part1 = new Part1();
        part1.testSimpleGene();
       
        
    }
    
    
    
}
