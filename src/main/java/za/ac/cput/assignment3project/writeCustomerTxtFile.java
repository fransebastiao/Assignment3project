/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.reverse;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author Franciel Sebastiao 
 */
public class writeCustomerTxtFile implements Comparator<Customer>{
    private String stHolderId, name, productType, productDescription, firstName, surName, address, dateOfBirth;
    private double credit;
    private boolean canRent;
    private int age;
    private FileReader src;
    private BufferedWriter crs;
    ObjectInputStream input;
    ObjectOutputStream output;
    ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public void customerArraylist(){
        System.out.println("================== CUSTOMERS =======================");
        customers.add(new Customer("C150", "Luke", "Atmyass", "Bellville", "27 Jan 1981", 1520.50, false));
        customers.add(new Customer("C130", "Stu", "Padassol", "Sea Point", "18 May 1987", 645.25, true));
        customers.add(new Customer("C100", "Mike", "Rohsopht", "Bellville", "24 Jan 1993", 975.10, true));
        customers.add(new Customer("C300", "Ivana.B", "Withew", "Langa", "16 July 1998", 1190.50, false));
        customers.add(new Customer("C250", "Eileen", "Sideways", "Nyanga", "27 Nov 1999", 190.85, true));
        customers.add(new Customer("C260", "Ima", "Stewpidas", "Atlantis", "27 Jan 2001", 1890.70, true));
        
        customers.sort(new writeCustomerTxtFile()); 

    }

    public void openTheFile(){    
        try{
            input = new ObjectInputStream( new FileInputStream("customerOutFile.txt"));
            System.out.println("***Txt file openned**");
        }

        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
        public void closeTheFile(){
        try{
            crs.close();
        }
        
        catch(IOException a){
            System.out.println(a);
        }
    }
        
    public void writeToTheFile(){
        
        //try{
            for(int i=0;i<customers.size();i++){
                //output.writeObject(customers.get(i));
                System.out.println(customers.get(i));
            }
        }
        //catch(IOException e){
           // System.out.println("");
        //}
        //finally{
            //System.out.println("Closing txt file...");
       // }
   // }
    
    public void determineAge(){
    
    }
    
    public void customersWhoCanRent(){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getCanRent() == true){
                int canRent = 0;
                canRent++;
                int total = canRent;
                System.out.println("Number of customers who can rent:" + total);
            }
            else
            {
                int cantRent = 0;
                int total = cantRent;
                System.out.println("Number of customers who can not rent:" + total);
            }
        }
    }
    
    

    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.getStHolderId().compareTo(o1.getStHolderId());
    }
}
