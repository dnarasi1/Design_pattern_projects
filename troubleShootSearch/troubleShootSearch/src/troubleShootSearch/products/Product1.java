/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products;

import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.FileProcessor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.MyLogger;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.Results;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor.VisitorI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author dheer
 */
public class Product1 implements ProductI {
    private ArrayList<String> product;
    private ArrayList<String> array;
    private String message;
    Results result = new Results();

    /**
     *
     * @return
     */
    @Override
    public Results getResult() {
        return result;
    }

    /**
     *
     * @param result
     */
    public void setResult(Results result) {
        this.result = result;
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getProduct() {
        return product;
    }

    private FileProcessor file1;
    private FileProcessor file;
    private FileProcessor fileS;

    /**
     *
     * @return
     */
    @Override
    public FileProcessor getFileS() {
        return fileS;
    }

    /**
     *
     * @return
     */
    public FileProcessor getFile() {
        return file;
    }

    /**
     *
     * @param arr
     * @param fileS
     * @param res
     */
    public Product1(ArrayList<String> arr ,FileProcessor fileS, Results res ) {
        product= new ArrayList<String>();
        this.array = arr;
        this.fileS = fileS;
        this.result = res;
        message = "product1 Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getArray() {
        return array;
    }

    /**
     *
     * @param f1
     */
    public void setFile1(FileProcessor f1){
        file1=f1;
    }

    /**
     *
     */
    @Override
    public void addLines(){
        String line = file1.readline();
        
        while(line!=null){
            
            String temp = "";
            StringTokenizer tokens = new StringTokenizer(line, " ");            
            while(tokens.hasMoreTokens()){
                
                temp+=tokens.nextToken()+ " ";
            }
            product.add(temp);
            line = file1.readline();
            
        }
       
  
    }
   
    /**
     *
     * @param visitor
     */
    @Override
    public void accept(VisitorI visitor) {
         visitor.visit(this);
    }
}
