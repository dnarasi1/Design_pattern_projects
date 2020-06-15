/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.driverStates;

import dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.util.Results;

/**
 *
 * @author dheer
 */
public interface DriverStateI {
    public static enum Position{LEADING,HOLDING_ON,LOSING};
    public void setDriverState(Integer n, int before, int after, Results result);
}
