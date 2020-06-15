/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util;

import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree.BuildTree;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree.Node;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree.Node.Decide;

/**
 *
 * @author dheer
 */
public class TreeBuilder {

    private FileProcessor file;
    private FileProcessor file2;
    private BuildTree tree_orig;
    private String message;
    private String message2;
    private String message4;

    public BuildTree getTree_orig() {
        return tree_orig;
    }

    public BuildTree getBackup_tree_1() {
        return backup_tree_1;
    }

    public BuildTree getBackup_tree_2() {
        return backup_tree_2;
    }
    private BuildTree backup_tree_1;
    private BuildTree backup_tree_2;

    /**
     *
     * @param fp
     */
    public void setFileProcessor(FileProcessor fp) {
        file = fp;
    }

    /**
     *
     */
    public TreeBuilder() {
        tree_orig = new BuildTree();
        backup_tree_1 = new BuildTree();
        backup_tree_2 = new BuildTree();
        message = "TreeBuilder Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     *
     * @param deleteFile
     */
    public void setFile2(FileProcessor deleteFile) {
        file2 = deleteFile;
    }

    /**
     *
     * @throws CloneNotSupportedException
     */
    public void processList() throws CloneNotSupportedException {

        String line = file.readline();
        Node backup_Node_1 = null;
        Node backup_Node_2 = null;
        while (line != null) {
            String[] tokens = line.split(":");
            int bNumber = Integer.parseInt(tokens[0]);
            String course = tokens[1];
            Node node_orig = tree_orig.search(bNumber);

            if (node_orig != null) {
                node_orig.setCourse(course);
                node_orig.notifyAll(course, Decide.insert);
                message2 = "More than one course has been added to a Bnumber: "+node_orig.getbNum();
                MyLogger.writeMessage(message2, MyLogger.DebugLevel.FROM_RESULTS);

            } else {
                node_orig = new Node(bNumber);
                node_orig.setCourse(course);
                backup_Node_1 = node_orig.clone();
                backup_Node_2 = node_orig.clone();
                node_orig.registerObserver(backup_Node_1);
                node_orig.registerObserver(backup_Node_2);
                tree_orig.insert(node_orig, bNumber);
                backup_tree_1.insert(backup_Node_1, bNumber);
                backup_tree_2.insert(backup_Node_2, bNumber);

            }

            line = file.readline();
        }
    }

    /**
     *
     */
    public void deleteCourse() {
        String line = file2.readline();
        while (line != null) {
            String[] tokens = line.split(":");
            int bNumber = Integer.parseInt(tokens[0]);
            String course = tokens[1];
            Node node_orig = tree_orig.search(bNumber);
            if (node_orig != null) {
                node_orig.removeCourse(course);
                node_orig.notifyAll(course, Decide.delete);
                if(node_orig.getCourse().isEmpty()){
                    message4 = node_orig.getbNum() + ": This node is empty";
                    MyLogger.writeMessage(message4, MyLogger.DebugLevel.IN_RESULTS);
                }
            }
            line = file2.readline();
        }
        
    }
}
