package dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.driver;

import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.MyArrayList;
import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.test.MyArrayListTest;
import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util.FileProcessor;
import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util.Results;
import java.io.File;
import java.io.IOException;

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

    public static void main(String args[]) throws IOException {
        argumentCheck(args);
        FileProcessor fileprocessor = new FileProcessor(args[0]);
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.setFileProcessor(fileprocessor);
        myArrayList.processList();
        Results r1 = new Results();
        r1.setPath(args[1]);
        r1.storeNewResult(myArrayList.getTotalSum());
        MyArrayListTest test =new MyArrayListTest(myArrayList,r1);
        test.testMe(myArrayList, r1);
    }
    public static void argumentCheck(String[] argument) {
        if (argument.length != 2 || argument[0].equals("${arg0}") || argument[1].equals("${arg1}")) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            File file1 = new File(argument[0]);
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
         }
    }
}
