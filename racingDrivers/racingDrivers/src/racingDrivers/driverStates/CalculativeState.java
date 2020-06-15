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
public class CalculativeState implements DriverStateI {
    private DriverContextSet currentPos;
    private String message, stateMessage;
    public CalculativeState(DriverContextSet context){
        this.currentPos=context;
        message = "calculativeState Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    private String caState = "CALCULATIVE";
    
    public void setDriverState(Integer n, int before, int after, Results res) { 
        String pos="";
        if(before < n && n < after){
            pos = Position.HOLDING_ON.toString();
        }
        
        if("HOLDING_ON".equals(pos)){
            res.storeNewResult(caState);
            res.storeNewResult(" ");
        }
        else{
            stateMessage = "The state is changed to Confident";
            MyLogger.writeMessage(stateMessage, MyLogger.DebugLevel.IN_RUN);
            currentPos.setState(currentPos.getConfidentState());
            currentPos.getConfidentState().setDriverState(n, before, after,res);
            
        }
    }
}
