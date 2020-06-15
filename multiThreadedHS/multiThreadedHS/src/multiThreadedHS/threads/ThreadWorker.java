/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.threads;

import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.FileProcessor;
import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.MyLogger;
import dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util.Results;
import java.util.ArrayList;

/*reference:
Insersort: https://stackoverflow.com/questions/3601472/insert-element-to-arraylist-with-ascending-order-and-no-duplicate-elements
*/
/**
 *
 * @author dheer
 */
public class ThreadWorker implements Runnable {
    private int num, count;
    private FileProcessor file;
    private ArrayList<Integer> store;
    private String message;

    /**
     *
     * @return
     */
    public ArrayList<Integer> getStore() {
        return store;
    }
    private int element;
    private FileProcessor file1;
    private ArrayList<ArrayList<Integer>> tList;
    public void getN(int number){
        num = number;
    }
    private Results result;

    /**
     *
     * @param aList
     * @param files
     * @param res1
     * @param i
     */
    public ThreadWorker(ArrayList aList,FileProcessor files, Results res1, int i) {
        this.store = aList;
        
        element = 0;
        this.file1 = files;
        this.result= res1;
        count=1;
        message = "ThreadWorker Class constructor is called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    
    /**
     *
     * @param array
     * @param value
     * @return
     */
    public ArrayList insertSort(ArrayList<Integer> array, int value){
        for(int i = 0; i<array.size(); i++){
            if (array.get(i)< value){
                continue;
            }
            if(array.get(i) == value){
                
                array.add(value);
                return array;
            }
            if (array.get(i)> value){
                array.add(i,value);
                return array;
            }
        }
        
        array.add(value);
        return array;
    }

    @Override
    public void run() {
        store.clear();
        String line = file1.readline();
        while(line!=null){
            
            element = Integer.parseInt(line);
                insertSort(store, element);
            count++;
            
            line = file1.readline();
        }
        for(int i=0; i<store.size(); i++){
            result.setArr(store.get(i));
        }
    }
}
