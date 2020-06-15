/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.driver;

import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products.Product1;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products.Product2;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products.Product3;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products.Product4;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.FileProcessor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.MyLogger;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.Results;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor.ExactMatchVisitor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor.NaiveStemmingMatchVisitor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor.SemanticMatchVisitor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor.VisitorI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dheer
 */
public class Driver {

    public static void main(String args[]) throws IOException {
        argumentCheck(args);
        MyLogger log = new MyLogger();
        log.setDebugValue(Integer.parseInt(args[7]));
        
        VisitorI exact = new ExactMatchVisitor();
        VisitorI naive = new NaiveStemmingMatchVisitor();
        VisitorI semantic = new SemanticMatchVisitor();

        FileProcessor f1 = new FileProcessor(args[0]);
        FileProcessor f2 = new FileProcessor(args[4]);
        FileProcessor f3 = new FileProcessor(args[1]);
        FileProcessor f4 = new FileProcessor(args[2]);
        FileProcessor f5 = new FileProcessor(args[3]);
        FileProcessor f6 = new FileProcessor(args[5]);
        
        Results res = new Results();
        res.setPath(args[6]);
        
        ArrayList<String> arr = new ArrayList<>();
        String input = "";
        String lines = f6.readline();

        while (lines != null) {
            arr.add(lines);
            lines = f6.readline();

        }

        Product1 store1 = new Product1(arr, f2, res);
        Product2 store2 = new Product2(arr, f2, res);
        Product3 store3 = new Product3(arr, f2, res);
        Product4 store4 = new Product4(arr, f2, res);
        
        store1.setFile1(f1);
        store2.setFile2(f3);
        store3.setFile3(f4);
        store4.setFile4(f5);
        
        store1.addLines();
        store2.addLines();
        store3.addLines();
        store4.addLines();
        
        store1.accept(exact);
        store2.accept(exact);
        store3.accept(exact);
        store4.accept(exact);
        
        store1.accept(naive);
        store2.accept(naive);
        store3.accept(naive);
        store4.accept(naive);
        
        
        store1.accept(semantic);
        store2.accept(semantic);
        store3.accept(semantic);
        store4.accept(semantic);
    }
    public static void argumentCheck(String[] argument) {
        if (argument.length != 8 || argument[0].equals("${arg0}") || argument[1].equals("${arg1}") || argument[2].equals("${arg2}")|| argument[3].equals("${arg3}")|| argument[4].equals("${arg4}")|| argument[5].equals("${arg5}")|| argument[6].equals("${arg6}")|| argument[7].equals("${arg7}")) {
            System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
            System.exit(0);
        } else {
            File file1 = new File(argument[0]);
            File file2 = new File(argument[1]);
            File file3 = new File(argument[1]);
            File file4 = new File(argument[1]);
            File file5 = new File(argument[1]);
            File file6 = new File(argument[1]);
            
            
            if (!file1.exists()) {
                System.err.println("Error: Given file in the first argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file2.exists()) {
                System.err.println("Error: Given file in the second argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file3.exists()) {
                System.err.println("Error: Given file in the third argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file4.exists()) {
                System.err.println("Error: Given file in the fourth argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file5.exists()) {
                System.err.println("Error: Given file in the fifth argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file6.exists()) {
                System.err.println("Error: Given file in the sixth argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file1.isFile()) {

                if (file1.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
            if (!file2.isFile()) {

                if (file2.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
            if (!file3.isFile()) {

                if (file3.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
            if (!file4.isFile()) {

                if (file4.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
            if (!file5.isFile()) {

                if (file5.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
            if (!file6.isFile()) {

                if (file6.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
        }
        try {
            Integer.parseInt(argument[7]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Given input in the 6th argument is not an integer. Please provide an integer between 0-4");
            System.exit(0);
        }
        if (Integer.parseInt(argument[7]) < 0 || Integer.parseInt(argument[7]) > 4) {
            System.err.println("DEBUG_VALUE invalid range");
            System.exit(0);
        }
    }
}
