/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree;

import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.FileProcessor;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.MyLogger;
import dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.util.TreeBuilder;
import java.util.ArrayList;

/**
 *
 * @author dheer
 */
public class Node implements Cloneable, SubjectI, ObserverI {
    
    private ArrayList<Node> observers;
    private ArrayList<String> course;
    private Node root;
    private String message;
    private String message3;

    /**
     *
     */
    public enum Decide {insert,delete};

    /**
     *
     * @param root
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     *
     * @return
     */
    public Node getRoot() {
        return root;
    }
    private Node leftChild;

    /**
     *
     * @return
     */
    public ArrayList<String> getCourse() {
        return course;
    }

    /**
     *
     * @param classes
     */
    public void setCourse(String classes) {
        if(!course.contains(classes)){
        course.add(classes);
        }
    }
    
    /**
     *
     * @param classes
     */
    public void removeCourse(String classes) {
        course.remove(classes);
    }

    /**
     *
     * @return
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     *
     * @param leftChild
     */
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    /**
     *
     * @return
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     *
     * @param rightChild
     */
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    /**
     *
     * @return
     */
    public int getbNum() {
        return bNum;
    }

    /**
     *
     * @param bNum
     */
    public void setbNum(int bNum) {
        this.bNum = bNum;
    }
    private Node rightChild;
    private int bNum;
    private String sub;
    TreeBuilder tBuild;
    
    /**
     *
     * @param bNumber
     */
    public Node(int bNumber) {
        bNum = bNumber;
        course = new ArrayList<>();
        observers = new ArrayList<>();
        root = null;
        leftChild = rightChild=null;
        message = "Node Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    
    @Override
    public Node clone()throws CloneNotSupportedException{
        Node clone=new Node(this.getbNum());
        clone.leftChild = this.getLeftChild();
        clone.rightChild = this.getRightChild();
        clone.course = this.getCourse();
        return clone;
    }

    /**
     *
     * @param observer
     */
    @Override
    public void registerObserver(Node observer) {
       observers.add(observer);
    }

    /**
     *
     * @param observer
     */
    @Override
    public void deleteObserver(Node observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
        }
    }

    /**
     *
     * @param course
     * @param d
     */
    @Override
    public void notifyAll(String course, Decide d) {
        for (int i = 0; i < observers.size(); i++) {
            Node observer = (Node)observers.get(i);
            observer.update(bNum,course, d);
        }
       message3 = "The observers are notified";
                MyLogger.writeMessage(message3, MyLogger.DebugLevel.IN_RUN);
    }

    /**
     *
     * @param bNumber
     * @param classes
     * @param d
     */
    @Override
    public void update(int bNumber, String classes, Decide d) {
        bNum = bNumber;
        if(d==Decide.insert){
            if(!course.contains(classes)){
            course.add(classes);
            }
        }
        if(d==Decide.delete){
            course.remove(classes);
        }
    }
    
    
}
