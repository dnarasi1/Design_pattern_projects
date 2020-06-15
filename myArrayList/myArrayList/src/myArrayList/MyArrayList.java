package dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList;

import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util.FileProcessor;
import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util.Results;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dheer
 */
public class MyArrayList {

    private Integer[] arr;
    private Map<Integer, Integer> hash_arr;

    public Map<Integer, Integer> getHash_arr() {
        return hash_arr;
    }
    private int count;

    public int getCount() {
        return count;
    }
    private int sums;
    private int length;
    private String totalSum;

    public String getTotalSum() {
        return totalSum;
    }
    private FileProcessor file;
    public MyArrayList() {
        arr = new Integer[5];
        hash_arr = new HashMap<Integer, Integer>();
        count = 0;
        sums = 0;
        length = arr.length;
    }

    
    public Integer[] getArr() {
        return arr;
    }
    public int getLength() {
        return arr.length;
    }
    public void setFileProcessor(FileProcessor fp){
        file=fp;
    }
     public void processList() {
        String line = file.readine();
        int element = 0;
        while (line != null) {
            element = Integer.parseInt(line);
            insertSorted(element);
            line = file.readine();
        }
       
        removeValue(7);
        if(sum() <= getLength()){
            compact();
        }
        totalSum="The sum of all the values in the array list is: "+String.valueOf(sum());
    }
    public Integer[] getNewArray(Integer[] arr) {
        int i = (int) (arr.length * 1.5);
        Integer[] newArray = new Integer[i];

        System.arraycopy(arr, 0, newArray, 0, arr.length);
        return newArray;
    }

    public void insertSorted(int newValue) {
        if (count == arr.length) {
            arr = getNewArray(arr);
        }
        arr[count] = newValue;
        hash_arr.put(count, arr[count]);
        for (int i = 0; i < count; i++) {
            if (newValue < arr[i]) {
                for (int j = count - 1; j >= i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i] = newValue;
                break;
            }
        }
        count++;

    }

    public void printInsertionOrder() {
        for (Map.Entry hash_arr : hash_arr.entrySet()) {
            System.out.println(hash_arr.getKey() + " " + hash_arr.getValue());
        }
    }
    public void removeValue(int value) {
        hash_arr.values().remove(value);
        for (int i = 0; i < count; i++) {
            if (arr[i] == value) {
                for (int j = i; j < count - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[count - 1] = null;
                count--;
                i--;
            }
        }
    }
    
    private Integer[] getShrinkArray(Integer[] currentArray){
        int i;
        for(i=0; i<currentArray.length;i++){
            if(currentArray[i]==null)
            {
                break;
            }
        }
        Integer[] shrinkArray = new Integer[i];
        System.arraycopy(currentArray, 0, shrinkArray, 0, shrinkArray.length);
        return shrinkArray;
    }
    
    public void compact(){
        arr = getShrinkArray(arr);
    }
  
    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
                if (arr[i] != null) {
                    if (arr[i] == value) {
                        return i;
                    }
                }
            }
        
        return -1;
    }

    public int size() {
            return count;
    }

    public int sum() {
        sums=0;
        for (int i = 0; i < count; i++) {
                sums += arr[i];
        }
        return sums;
    }
    
    public String toString(){
        String str="My custom array list consists of the following elements: ";
        str+="\n";
        for(int i=0;i<count;i++){
            str+=String.valueOf(arr[i]) + "\t";
        }
        return str;
    }
}
