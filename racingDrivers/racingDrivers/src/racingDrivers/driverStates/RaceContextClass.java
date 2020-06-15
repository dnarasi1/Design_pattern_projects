/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.driverStates;

import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.FileProcessor;
import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.MyLogger;
import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.Results;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Random;
//import static java.util.Map.entry;
import java.util.TreeMap;

/**
 *
 * @author dheer
 */


public class RaceContextClass {
    private FileProcessor file;
    private int total = 0;
    public int getTotal() {
        return total;
    }
    private LinkedHashMap<Double, Double> link;
    private TreeMap<Double,Double> sortMap;
    private Double count;
    private boolean set;
    private boolean flag;
    private Double tempCount;
    private Double[] addHash;
    private Results passresult;
    private Random rand;
    private String message, resultMessage;
    public void setFileProcessor(FileProcessor fp){
        file=fp;
    }
    public RaceContextClass(Results result) {
        link = new LinkedHashMap();
        total =0;
        set = true;
        flag = true;
        count=1.0;
        tempCount = 1.0;
        this.passresult = result;
        rand = new Random();
        message = "Race Context Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    private DriverContextSet driverContext = new DriverContextSet();
    
    public void processList() {
        driverContext.setSecondResult(passresult);
        String line = file.readline();
        
        while (line != null) {
            if(set==true){
                total = Integer.parseInt(line);
                line = file.readline();
            }
            set = false;
            sortMap = new TreeMap(Collections.reverseOrder());
            String[] tokens = line.split(" ");
            
            if(flag==true){
                addHash = new Double[total];
                Arrays.fill(addHash, 0.0);
            }
            for(int i=0; i<total;i++){
                addHash[i] = addHash[i] +  Double.parseDouble(tokens[i]);
                link.put(Double.valueOf(i),addHash[i]);
            }
            flag=false;
            
            link.entrySet().forEach((entry)->{
                
                if (sortMap.containsKey(entry.getValue())){
                    Double obj = sortMap.remove(entry.getValue());
                    sortMap.put(entry.getValue()*-1, obj);
                    sortMap.put((entry.getValue()+tempCount)*-1, entry.getKey());
                    tempCount = rand.nextDouble();
                }
                else if (sortMap.containsKey(-entry.getValue())){
                    sortMap.put((entry.getValue()+tempCount)*-1, entry.getKey());
                    tempCount = rand.nextDouble();
                }
                else{
                    sortMap.put(entry.getValue(), entry.getKey());
                }
            });
            sortMap.entrySet().forEach((entry) -> {
                if(entry.getKey()<0){
                    link.put(entry.getValue(), count*-1);
                    count++;
                }
                else{
                    link.put(entry.getValue(), count);
                    count++;
                }    
            });
            link.entrySet().forEach((entry)->{
                driverContext.driverPosition(entry.getValue().intValue(), total);
            });
            count = 1.0;
            passresult.storeNewResult("\n");
            
            passresult.writeToFile();
            line = file.readline();
        }
        resultMessage = passresult.getResult();
        MyLogger.writeMessage(resultMessage, MyLogger.DebugLevel.IN_RESULTS);
    }
}
