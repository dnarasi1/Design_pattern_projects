/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_3.studentCoursesBackup.src.studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dheer
 */

/* reference: 
https://www.journaldev.com/23086/binary-search-tree-bst-search-insert-remove
https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
 */
public class BuildTree {

    private Node root;

    /**
     *
     * @param temp
     * @param value
     */
    public void insert(Node temp, int value) {
        if (root == null) {
            root = temp;
        } else {
            Node current = root, parent = null;
            while (true) {
                parent = current;

                if (value < (int) current.getbNum()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(temp);
                        return;
                    }

                } else if (value > (int) current.getbNum()) {
                    current = current.getRightChild();

                    if (current == null) {
                        parent.setRightChild(temp);
                        return;
                    }
                }

            }
        }
        
    }

    /**
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        Node current = root;
        while (current != null) {
            if ((int) current.getbNum() == value) {
                return current;
            }

            if (value < (int) current.getbNum()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return null;
    }

    /**
     *
     */
    public String printLevelOrder() {
        String result = "";
        if (root == null) {
            return null;
        }
 
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (true) {
 
            int nodeCount = q.size();
            if (nodeCount == 0) {
                break;
            }

            while (nodeCount > 0) {
                Node node = q.peek();
                int length = (int)(Math.log10(node.getbNum())+1);
                if(length==1){
                    String padded = String.format("%04d" , node.getbNum());
                    result+= padded + " " + node.getCourse() + "*" + "\n";
                }
                else if(length==2){
                    String padded1 = String.format("%04d" , node.getbNum());
                    result+= padded1 + " " + node.getCourse() + "*" + "\n";
                }
                else if(length==3){
                    String padded2 = String.format("%04d" , node.getbNum());
                    result+= padded2 + " " + node.getCourse() + "*" + "\n";
                }
                else{
                    result+= node.getbNum() + " " + node.getCourse() + "*" + "\n";
                }
                q.remove();
                if (node.getLeftChild() != null) {
                    q.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    q.add(node.getRightChild());
                }
                nodeCount--;
            }
        }
        return result;
    }
}
