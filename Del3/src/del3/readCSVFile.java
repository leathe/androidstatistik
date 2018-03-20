/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Cracker0
 */
public class readCSVFile {
    private static ArrayList<Float> xl = new ArrayList();
    private static ArrayList<Float> yl = new ArrayList();
    
    public readCSVFile(String fileLocation) {
        
        xl = new ArrayList();
        yl = new ArrayList();
        
        try 
        {
            File file = new File(fileLocation);
            Scanner scanner = new Scanner(file);
             
            while (scanner.hasNext()) 
            {
                String[] splitted = scanner.next().split(",");
                xl.add(Float.valueOf(splitted[0]));
                yl.add(Float.valueOf(splitted[1]));
            }
            
            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("ERROR: " + e.getMessage());
        } 

        for(int i = 0; i < xl.size(); i++)
        {
            System.out.println("Längd: " + xl.get(i) + " Skonummer: " + yl.get(i));
        }
    }
    
}
