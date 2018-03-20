/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package del3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Del3 {
    
    private static ArrayList<Float> xl;
    private static ArrayList<Float> yl;
    private static float[] height;
    private static float[] shoeSize;
    public static void main(String[] args) {
        float[] a = new float[] {3,4,5,6};
        float[] b = new float[] {5,3,5,7};
        readInFile();
        System.out.println("Coef k: "+Statistics.getCorrelationCoefficient(a, b));
        System.out.println("Linear Reg: "+Statistics.getLinearRegressionLine(a, b));
    }
    
    public static void readInFile() {
        xl = new ArrayList();
        yl = new ArrayList();
        
        try 
        {
            File file = new File("D:\\Development\\androidstatistik\\Del3\\src\\del3\\namnOlangddata.csv");
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
        height = new float[xl.size()];
        shoeSize = new float[yl.size()];
        
        int i = 0;
        for(Float f : xl) {
            height[i++] = (f != null ? f : Float.NaN);
        }
        
        int j = 0;
        for(Float f : yl) {
            shoeSize[j++] = (f != null ? f : Float.NaN);
        }

//        for(int i = 0; i < xl.size(); i++)
//        {
//            System.out.println("Längd: " + xl.get(i) + " Skonummer: " + yl.get(i));
//        }
    }
    
}
