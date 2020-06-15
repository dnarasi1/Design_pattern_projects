/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author dheer
 */
public class ProductsList {
    private ArrayList<ArrayList<String>> product1;
    private ArrayList<ArrayList<String>> product2;
    private ArrayList<ArrayList<String>> product3;
    private ArrayList<ArrayList<String>> product4;
    
    
    private FileProcessor file1;
    private FileProcessor file2;
    private FileProcessor file3;
    private FileProcessor file4;

    public ProductsList() {
        product1 = new ArrayList<ArrayList<String>>();
        product2 = new ArrayList<>();
        product3 = new ArrayList<>();
        product4 = new ArrayList<>();
        
    }
    
    public void setFile1(FileProcessor f1){
        file1=f1;
    }
    public void setFile2(FileProcessor f2){
        file2=f2;
    }
    public void setFile3(FileProcessor f3){
        file3=f3;
    }
    public void setFile4(FileProcessor f4){
        file4=f4;
    }
    public void addLines(){
        String line = file1.readline();
        
        while(line!=null){
            ArrayList<String> temp = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(line, " ");            
            while(tokens.hasMoreTokens()){
                temp.add(tokens.nextToken());
            }
            product1.add(temp);
            line = file1.readline();
            
        }
        String line2 = file2.readline();
        
        while(line2!=null){
            ArrayList<String> temp = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(line2, " ");            
            while(tokens.hasMoreTokens()){
                temp.add(tokens.nextToken());
            }
            product2.add(temp);
            line2 = file2.readline();
            
        }
        String line3 = file3.readline();
        
        while(line3!=null){
            ArrayList<String> temp = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(line3, " ");            
            while(tokens.hasMoreTokens()){
                temp.add(tokens.nextToken());
            }
            product3.add(temp);
            line3 = file3.readline();
            
        }
        String line4 = file4.readline();
        
        while(line4!=null){
            ArrayList<String> temp = new ArrayList<>();
            StringTokenizer tokens = new StringTokenizer(line4, " ");            
            while(tokens.hasMoreTokens()){
                temp.add(tokens.nextToken());
            }
            product4.add(temp);
            line4 = file4.readline();
            
        }
        


    }
}
