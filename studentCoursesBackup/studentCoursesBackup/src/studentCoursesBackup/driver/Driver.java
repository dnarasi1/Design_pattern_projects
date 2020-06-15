/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.driver;

import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree.Node;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.FileProcessor;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.MyLogger;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.Results;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.TreeBuilder;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author dheer
 */
public class Driver {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        argumentCheck(args);
         MyLogger log = new MyLogger();
        log.setDebugValue(Integer.parseInt(args[5]));
        FileProcessor fp = new FileProcessor(args[0]);
        FileProcessor deleteFile = new FileProcessor(args[1]);
        TreeBuilder store = new TreeBuilder();
        store.setFileProcessor(fp);
        store.setFile2(deleteFile);
        store.processList();
        store.deleteCourse();
        Results res1 = new Results();
        Results res2 = new Results();
        Results res3 = new Results();
        res1.setPath(args[2]);
        res2.setPath(args[3]);
        res3.setPath(args[4]);
        String output1 = store.getTree_orig().printLevelOrder();
        String output2 = store.getBackup_tree_1().printLevelOrder();
        String output3 = store.getBackup_tree_2().printLevelOrder();
        res1.storeNewResult(output1);
        res1.writeToFile();
        res2.storeNewResult(output2);
        res2.writeToFile();
        res3.storeNewResult(output3);
        res3.writeToFile();
    }

    /**
     *
     * @param argument
     */
    public static void argumentCheck(String[] argument) {
        if (argument.length != 6 || argument[0].equals("${arg0}") || argument[1].equals("${arg1}") || argument[2].equals("${arg2}")|| argument[3].equals("${arg3}")|| argument[4].equals("${arg4}")|| argument[5].equals("${arg5}")) {
            System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
            System.exit(0);
        } else {
            File file1 = new File(argument[0]);
            File file2 = new File(argument[1]);
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
        }
        try {
            Integer.parseInt(argument[5]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Given input in the 6th argument is not an integer. Please provide an integer between 0-4");
            System.exit(0);
        }
        if (Integer.parseInt(argument[5]) < 0 || Integer.parseInt(argument[5]) > 4) {
            System.err.println("DEBUG_VALUE invalid range");
            System.exit(0);
        }
    }
}
