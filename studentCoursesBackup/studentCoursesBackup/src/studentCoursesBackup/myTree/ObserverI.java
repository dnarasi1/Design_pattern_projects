/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree;

import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree.Node.Decide;

/**
 *
 * @author dheer
 */
public interface ObserverI {
    public void update(int bNumber, String classes, Decide d);
}
