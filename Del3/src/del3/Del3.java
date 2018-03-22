/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Del3 {
    
    private static ArrayList<Double> xl;
    private static ArrayList<Double> yl;
    private static double[] height;
    private static double[] shoeSize;
    public static void main(String[] args) {
        readInFile();
        System.out.println("Correlation coefficient r="+Statistics.getCorrelationCoefficient(height, shoeSize)+"\n"+
                Statistics.getLinearRegressionLine(height, shoeSize));
    }
    
    public static void readInFile() {
        xl = new ArrayList();
        yl = new ArrayList();
        
        try 
        {
            File file = new File("D:\\Development\\androidstatistik\\Del3\\src\\del3\\data.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) 
            {
                String[] splitted = scanner.next().split(",");
                xl.add(Double.valueOf(splitted[0]));
                yl.add(Double.valueOf(splitted[1]));
            }
            
            scanner.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("ERROR: " + e.getMessage());
        }
        height = new double[xl.size()];
        shoeSize = new double[yl.size()];
        
        int i = 0;
        for(Double f : xl) {
            height[i++] = (f != null ? f : Double.NaN);
        }
        
        int j = 0;
        for(Double f : yl) {
            shoeSize[j++] = (f != null ? f : Double.NaN);
        }
//        System.out.println("Height: "+Arrays.toString(height) + "Count: " +height.length);
//        System.out.println("ShoeSize: "+Arrays.toString(shoeSize) + " Count:" +shoeSize.length);
//        for(int i = 0; i < xl.size(); i++)
//        {
//            System.out.println("Längd: " + xl.get(i) + " Skonummer: " + yl.get(i));
//        }
    }
    
}
