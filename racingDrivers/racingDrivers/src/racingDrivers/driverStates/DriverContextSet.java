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



public class DriverContextSet implements DriverContextI{

   private String currentState;
   private DriverStateI recklessState, confidentState, calculativeState;

    public DriverStateI getRecklessState() {
        return recklessState;
    }

    public DriverStateI getConfidentState() {
        return confidentState;
    }

    public DriverStateI getCalculativeState() {
        return calculativeState;
    }
   private DriverStateI currentStateI;
   private Results secondResult;
   private String message;

    public void setSecondResult(Results secondResult) {
        this.secondResult = secondResult;
    }

    public Results getSecondResult() {
        return secondResult;
    }
   public DriverContextSet(){
       recklessState=new RecklessState(this);
       confidentState=new ConfidentState(this);
       calculativeState=new CalculativeState(this);
        message = "DriverContextSet Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
   }
   
    public String getCurrentState() {
        return currentState;
    }
    int before;
    int after;
    String result;

    @Override
    public void setState(DriverStateI state) {
        this.currentStateI=state;
    }
    
    @Override
    public void driverPosition(Integer n, Integer totalDrivers) {    
        before = (int) Math.round(0.3 * totalDrivers);
        after = (int) Math.round(0.7 * totalDrivers);
        currentStateI=recklessState;
        currentStateI.setDriverState(n,before,after, secondResult);
    }  
}