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
public class RecklessState implements DriverStateI{
    private DriverContextSet currentPos;
    private String message, stateMessage, positionMessage;
    
    public RecklessState(DriverContextSet context){
        this.currentPos=context;
        message = "RecklessState Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
        
    }
    private String dState = "RECKLESS";

    public String getdState() {
        return dState;
    }
    

    @Override
    public void setDriverState(Integer n, int before, int after, Results res) { 
        String pos="";
        if(after<=n){
            pos = Position.LOSING.toString();
        }
        if("LOSING".equals(pos) || n<0){
            res.storeNewResult(dState);
            res.storeNewResult(" ");
            if(n<0){
                positionMessage = "The Driver is sharing the same position with other driver";
                MyLogger.writeMessage(positionMessage, MyLogger.DebugLevel.FROM_RESULTS);
            }
        }
        else{
            stateMessage = "The state is changed to Calculative";
            MyLogger.writeMessage(stateMessage, MyLogger.DebugLevel.IN_RUN);
            currentPos.setState(currentPos.getCalculativeState());
            currentPos.getCalculativeState().setDriverState(n, before, after,res);
        }
    }
    
}
