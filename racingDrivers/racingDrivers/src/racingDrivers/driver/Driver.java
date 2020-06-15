/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.driver;

import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.driverStates.RaceContextClass;
import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.FileProcessor;
import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.MyLogger;
import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.Results;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author dheer
 */
public class Driver {

    public static void main(String[] args) throws IOException {
	argumentCheck(args);
        MyLogger log = new MyLogger();
        log.setDebugValue(Integer.parseInt(args[2]));
        Results result = new Results();
        result.setPath(args[1]);

        FileProcessor fp = new FileProcessor(args[0]);
        RaceContextClass context = new RaceContextClass(result);
        context.setFileProcessor(fp);
        context.processList();
    }

    public static void argumentCheck(String[] argument) {
        if (argument.length != 3 || argument[0].equals("${arg0}") || argument[1].equals("${arg1}") || argument[2].equals("${arg2}")) {
            System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
            System.exit(0);
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
	try {
            Integer.parseInt(argument[2]);
        } catch (NumberFormatException e) {
            System.err.println("Error: Given input in the 3rd argument is not an integer. Please provide an integer between 0-4");
            System.exit(0);
        }
        if (Integer.parseInt(argument[2]) < 0 || Integer.parseInt(argument[2]) > 4) {
            System.err.println("DEBUG_VALUE invalid range");
            System.exit(0);
        }
    }
}
