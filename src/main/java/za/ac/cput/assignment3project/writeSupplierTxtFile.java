/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.assignment3project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.Comparator;

/**
 *
 * @author Franciel Sebastiao
 */
public class writeSupplierTxtFile implements Comparator<Supplier> {
    private Supplier supplier;
    private FileWriter src;
    private BufferedWriter crs;
    ObjectInputStream input;
    ObjectOutputStream output;
    ArrayList<Supplier> suppliers = new ArrayList<Supplier>();   

    public void openThisFile(){    
        try{
            FileWriter src = new FileWriter("supplierOutFile.txt");
            BufferedWriter crs = new BufferedWriter(src);
            crs.write(String.format("%-15s%-15s%-15s%-15s\n", "Id", "Name", "Prod Type", "Description"));
            crs.write(String.format("%-15s%-15s%-15s%-15s\n", "Id", "Name", "Prod Type", "Description"));
            crs.close();
        }

        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void suppliersArraylist(){
        System.out.println("================== SUPPLIER =======================");
        suppliers.add(new Supplier("S270", "Grand Theft Auto", "Toyota", "Mid-size sedan"));
        suppliers.add(new Supplier("S400", "Prime Motors", "Lexus", "Luxury sedan"));
        suppliers.add(new Supplier("S300", "We got Cars", "Toyota", "10-seater minibus"));
        suppliers.add(new Supplier("S350", "Auto Delight", "BMW", "Luxury SUV"));
        suppliers.add(new Supplier("S290", "MotorMania", "Hyundai", "compact budget")); 
        //sort(suppliers);
        suppliers.sort(new writeSupplierTxtFile());
        //try{
        for(int i=0;i<suppliers.size();i++){
            //output.writeObject(suppliers.get(i));
            System.out.println(suppliers.get(i));
        }
        //}
        /*catch(IOException e){
           System.out.println("");
        }
        finally{
           System.out.println("Closing txt file...");
       }*/
  
    }
    
    @Override
    public int compare(Supplier o1, Supplier o2) {
        return o2.getName().compareTo(o1.getName());
    }
    
    public void closeThisFile(){
        try{
            crs.close();
        }
        
        catch(IOException a){
            System.out.println(a);
        }
    }
}
