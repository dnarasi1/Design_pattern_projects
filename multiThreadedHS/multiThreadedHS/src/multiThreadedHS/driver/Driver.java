package dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.driver;

import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.threads.ThreadWorker;
import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.FileProcessor;
import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.MergeSort;
import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.MyLogger;
import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.Results;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dheer
 */
public class Driver {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        argumentCheck(args);
        MyLogger log = new MyLogger();
        String message = "", resMessage = "", merMessage = "", nMessage = "\n";
        ArrayList<FileProcessor> fileArray = new ArrayList<>(); 
        ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
        ArrayList<Integer> aGroup = new ArrayList<>();
        int num = Integer.parseInt(args[0]);
        log.setDebugValue(Integer.parseInt(args[num+2]));
        for(int i=0; i<num; i++){
            fileArray.add(new FileProcessor(args[i+1]));
        }
        Results res = new Results();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(new ThreadWorker(aGroup, fileArray.get(i), res, i));    
        }
        for (int i = 0; i < num; i++) {
            threads[i].start();    
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
            ThreadWorker r = new ThreadWorker(aGroup, fileArray.get(i), res, i);
            aList.add((ArrayList<Integer>)r.getStore().clone());
        }
        for (int i = 0; i < aList.size(); i++) {
            for (int j = 0; j < aList.get(i).size(); j++) {
                message += aList.get(i).get(j) + ", ";
            }
            message +="\n";
        }
        MyLogger.writeMessage(message, MyLogger.DebugLevel.FROM_DATA_STRUCTURE);
            
        for (int i = 0; i < res.getArr().size();i++) {
            resMessage+=res.getArr().get(i) + ", ";
        }
        MyLogger.writeMessage(resMessage, MyLogger.DebugLevel.IN_RESULTS);
        
        MergeSort rMerge = new MergeSort();
        rMerge.doMergeSort(res.getArr());
        for (int i = 0; i < res.getArr().size();i++) {
            merMessage+=res.getArr().get(i)+ ", ";
        }
        MyLogger.writeMessage(merMessage, MyLogger.DebugLevel.IN_RUN);
        res.setPath(args[num+1]);
        for(int i=0; i<res.getArr().size(); i++){
            res.storeNewResult(res.getArr().get(i));
        }
        res.writeToFile();
    }
    
    /**
     *
     * @param argument
     */
    public static void argumentCheck(String[] argument) {
       // if (argument.length < 4 || argument.length>6) {
       //     System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
       //     System.exit(0);
       // } 
        if(argument.length ==4){
            File file1 = new File(argument[1]);
            if (!file1.exists()) {
                System.err.println("Error: Given file in the first argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file1.isFile()) {

                if (file1.isDirectory()) {
                    System.err.println("Error: Given file path is that of a directory. Please provide file path");
                    System.exit(0);
                }
            }
            try {
            Integer.parseInt(argument[3]);
		} catch (NumberFormatException e) {
            System.err.println("Error: Given input in the 3rd argument is not an integer. Please provide an integer between 0-4");
            
            System.exit(0);
        }
        if (Integer.parseInt(argument[3]) < 0 || Integer.parseInt(argument[3]) > 4) {
            System.err.println("DEBUG_VALUE invalid range");
            System.exit(0);
        }
        }
        if(argument.length ==5){
            File file1 = new File(argument[1]);
            File file2 = new File(argument[2]);
            if (!file1.exists()) {
                System.err.println("Error: Given file in the first argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file2.exists()) {
                System.err.println("Error: Given file in the second argument doesn't exist. Please provide correct file path.");
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
            try {
            Integer.parseInt(argument[4]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Given input in the 4th argument is not an integer. Please provide an integer between 0-4");
            System.exit(0);
        }
        if (Integer.parseInt(argument[4]) < 0 || Integer.parseInt(argument[4]) > 4) {
            System.err.println("DEBUG_VALUE invalid range");
            System.exit(0);
        }
        }
        if(argument.length ==6){
            File file1 = new File(argument[1]);
            File file2 = new File(argument[2]);
            File file3 = new File(argument[3]);
            if (!file1.exists()) {
                System.err.println("Error: Given file in the first argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file2.exists()) {
                System.err.println("Error: Given file in the second argument doesn't exist. Please provide correct file path.");
                System.exit(0);
            }
            if (!file3.exists()) {
                System.err.println("Error: Given file in the first argument doesn't exist. Please provide correct file path.");
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
            try {
            Integer.parseInt(argument[5]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Given input in the 5th argument is not an integer. Please provide an integer between 0-4");
            System.exit(0);
        }
        if (Integer.parseInt(argument[5]) < 0 || Integer.parseInt(argument[5]) > 4) {
            System.err.println("DEBUG_VALUE invalid range");
            System.exit(0);
        }
        }
        
    }
}
