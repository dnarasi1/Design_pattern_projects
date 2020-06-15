/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*reference:
https://repl.it/@StephanieStern/Merge-Sort-with-ArrayList
*/
package dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util;

import java.util.ArrayList;


/**
 *
 * @author dheer
 */
public class MergeSort {
    
    /**
     *
     * @param numbers
     */
    public void doMergeSort(ArrayList<Integer> numbers){
  int middle;
  ArrayList<Integer> left = new ArrayList<>();
  ArrayList<Integer> right = new ArrayList<>();
  
  if (numbers.size() > 1) {
     middle = numbers.size() / 2;
        // copy the left half of numbers into left.
        for (int i = 0; i < middle; i++) 
            left.add(numbers.get(i));
 
        //copy the right half of numbers into right.
        for (int j = middle; j < numbers.size(); j++)
            right.add(numbers.get(j));
            
     doMergeSort(left);
     doMergeSort(right);
     
     merge(numbers, left, right);
  }
}

    /**
     *
     * @param numbers
     * @param left
     * @param right
     */
    public void merge(ArrayList<Integer> numbers, ArrayList<Integer> left, ArrayList<Integer> right){
  //set up a temporary arraylist to build the merge list
  ArrayList<Integer> temp = new ArrayList<>(); 
  
  //set up index values for merging the two lists 
  int numbersIndex = 0;    
  int leftIndex = 0;
  int rightIndex = 0;

  while (leftIndex < left.size() && rightIndex < right.size()) {
    if (left.get(leftIndex) < right.get(rightIndex) ) {
            numbers.set(numbersIndex, left.get(leftIndex));
            leftIndex++;
        } else {
            numbers.set(numbersIndex, right.get(rightIndex));
            rightIndex++;
        }
        numbersIndex++;
    }
   
    int tempIndex = 0;
    if (leftIndex >= left.size()) {
        temp = right;
        tempIndex = rightIndex;
    } 
    else {
        temp = left;
        tempIndex = leftIndex;
    }
 
    for (int i = tempIndex; i < temp.size(); i++) {
        numbers.set(numbersIndex, temp.get(i));
        numbersIndex++;
    }
 }
}
