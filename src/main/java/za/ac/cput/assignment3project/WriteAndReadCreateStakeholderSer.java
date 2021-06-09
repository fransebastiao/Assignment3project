/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 *
 * @author Franciel Sebastiao
 */
public class WriteAndReadCreateStakeholderSer {
    
    private ObjectInputStream input;
    private Customer customer;
    private Supplier supplier;
    private int age;
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
    
    public void openFile(){
        try{
            input = new ObjectInputStream( new FileInputStream("stakeholder.ser"));
            System.out.println("***Ser file created and opened for reading***");
        }
    
        catch(IOException a){
            System.out.println("Error opening Ser file:" + a.getMessage());
        }
    }
    
    public void closeFile(){
        try{
            input.close();
        }
        
        catch(IOException a){
            System.out.println("Error closing Ser file:" + a.getMessage());
        }
    }
    
    public void readStakeholderSerFile(){
        try{
            for(int i = 0; i < customers.size(); i++){
            customers.set(i, (Customer)input.readObject());
            System.out.println(customers.get(i));
            }
        }
        
        catch(ClassNotFoundException cnfe){
            System.out.println("Error reading Ser file:" + cnfe.getMessage());
        } 
        
        catch (IOException ex) {
            System.out.println("Error reading from Ser file:" + ex.getMessage());
        }
        
        finally{
            closeFile();
            System.out.println("***File has been closed***");
        }
    }
    
    public static void main(String args[])  {
        WriteAndReadCreateStakeholderSer obj = new WriteAndReadCreateStakeholderSer();
        obj.openFile();
        obj.readStakeholderSerFile();   
        writeCustomerTxtFile obj2 = new writeCustomerTxtFile();
        obj2.openTheFile();
        obj2.customerArraylist();
        obj2.writeToTheFile();
        obj2.customersWhoCanRent();
        writeSupplierTxtFile obj3 = new writeSupplierTxtFile();
        obj3.openThisFile();
        obj3.suppliersArraylist();

    }
}
