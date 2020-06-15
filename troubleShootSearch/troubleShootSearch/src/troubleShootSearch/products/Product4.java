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
import java.util.StringTokenizer;

/**
 *
 * @author dheer
 */
public class Product4 implements ProductI {

    private ArrayList<String> product;
    private ArrayList<String> array;
    private FileProcessor file4;
    private FileProcessor fileS;
    Results result = new Results();
    private String message;

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
    public FileProcessor getFileS() {
        return fileS;
    }

    /**
     *
     * @param arr
     * @param fileS
     * @param res
     */
    public Product4(ArrayList<String> arr, FileProcessor fileS, Results res) {
        product = new ArrayList<String>();
        this.array = arr;
        this.fileS = fileS;
        this.result = res;
        message = "product4 Class constructor is called";
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
     * @param f4
     */
    public void setFile4(FileProcessor f4) {
        file4 = f4;
    }

    /**
     *
     */
    @Override
    public void addLines() {
        String line4 = file4.readline();

        while (line4 != null) {
            String temp = "";
            StringTokenizer tokens = new StringTokenizer(line4, " ");            
            while(tokens.hasMoreTokens()){
                
                temp+=tokens.nextToken()+ " ";
            }
            product.add(temp);
            line4 = file4.readline();

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

    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getProduct() {
        return product;
    }
}
