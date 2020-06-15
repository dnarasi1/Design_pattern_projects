/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_2.racingDrivers.src.racingDrivers.driverStates;

/**
 *
 * @author dheer
 */
public interface DriverContextI {
    public void setState(DriverStateI state);
    public void driverPosition(Integer n, Integer totalDrivers);
}
