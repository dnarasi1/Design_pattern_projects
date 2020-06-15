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
public interface SubjectI {
    public void registerObserver(Node observer);
    public void deleteObserver(Node Observer);
    public void notifyAll(String course, Decide d);
}
