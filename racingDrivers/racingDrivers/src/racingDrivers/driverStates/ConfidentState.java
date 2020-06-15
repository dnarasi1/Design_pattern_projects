/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.driverStates;

import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.MyLogger;
import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.Results;

/**
 *
 * @author dheer
 */
public class ConfidentState implements DriverStateI {
    private DriverContextSet currentPos;
    private String message;
    
    public ConfidentState(DriverContextSet context){
        this.currentPos=context;
        message = "ConfidentState Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    private String coState = "CONFIDENT";
   
    @Override
    public void setDriverState(Integer n, int before, int after, Results res) { 
         String pos="";
        if(n<= before){ 
            pos = Position.LEADING.toString();
        }
        
        if("LEADING".equals(pos)){
            res.storeNewResult(coState);
            res.storeNewResult(" ");
        }
    }
}
