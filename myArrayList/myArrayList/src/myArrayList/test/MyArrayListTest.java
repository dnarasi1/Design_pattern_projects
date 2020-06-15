package dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.test;


import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.MyArrayList;
import dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util.Results;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* isSorted method is reffered from "https://stackoverflow.com/questions/19458278/check-if-an-array-is-sorted-return-true-or-false"
/**
 *
 * @author dheer
 */
public class MyArrayListTest {
    private MyArrayList myArray;
    private Results myResult;
    public MyArrayListTest(MyArrayList array, Results result){
        myArray=array;
        myResult=result;
    }
    public Integer[] testArray = new Integer[5];
    public void testMe(MyArrayList array, Results result){
        array = myArray;
        result = myResult;
        insertSortedTest(array,result);
        checkArraySize(array,result);
        testRemoveValue(array,result);
        testCompact(array,result);
        testIndexOf(array,result);
        testSize(array,result);
        testSum(array,result);
        testPrintInsertion2(array,result);
        testCompact2(array, result);
        Indexof2(array,result);
    }
    
    public static boolean isSorted(Integer[] a) {
    for (int i = 0; i < a.length - 1; i++) {
        if(a[i]!=null&&a[i+1]!=null){
        if (a[i] > a[i + 1]) {
            return false; 
        }
        }
    }
    return true; 
    }
    
    public void insertSortedTest(MyArrayList array, Results result){ 
        array.insertSorted(10);
        array.insertSorted(20);
        array.insertSorted(-1);
        array.insertSorted(0);
        array.insertSorted(5);
        result.storeNewResult("***Testing if the elements are inserted in ascending order***");
        if(isSorted(array.getArr())){
            result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    
    public void checkArraySize(MyArrayList array, Results result){
        int before = array.getLength();
        array.insertSorted(10);
        array.insertSorted(20);
        array.insertSorted(-1);
        array.insertSorted(0);
        array.insertSorted(5);
        array.insertSorted(10);
        int after = array.getLength();
        result.storeNewResult("***Testing if the array size increases after adding new elements***");
        if(before==after){
            result.storeNewResult("Fail");
        }
        else{
            result.storeNewResult("Pass");
        }
        result.writeToFile(result.getResult());
    }
    public void testRemoveValue(MyArrayList array, Results result){
        int sizeBefore = array.size();
        array.removeValue(10);
        int sizeAfter = array.size();
        result.storeNewResult("***Testing if the array size decreases and the elements are sorted after removeValue***");
        if((sizeBefore >= sizeAfter) && isSorted(array.getArr())){
            result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    public void testCompact(MyArrayList array, Results result){
        array.insertSorted(10);
        array.insertSorted(20);
        array.insertSorted(30);
        array.insertSorted(20);
        array.insertSorted(40);
        array.insertSorted(20);
        int before = array.getLength();
        array.removeValue(20);
        array.removeValue(10);
        array.compact();
        int after = array.getLength();
        result.storeNewResult("***Testing compact functionality***");
        if(before>=after){
           result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    
    public void testIndexOf(MyArrayList array, Results result){
        result.storeNewResult("***IndexOf returns -1 if the value doesnot exist***");
        if(array.indexOf(99)==-1){
             result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    
    public void testCompact2(MyArrayList array, Results result){
        array.insertSorted(10);
        array.insertSorted(20);
        array.insertSorted(30);
        array.insertSorted(20);
        array.insertSorted(40);
        array.insertSorted(20);
        array.removeValue(20);
        array.removeValue(10);
        array.compact();
        Integer[] arrayTest=array.getArr();
        boolean flag=true;
        for(int i=0;i<arrayTest.length;i++){
            if(arrayTest[i]==null){
                flag=false;
            }
        }
        result.storeNewResult("***After calling compact function the array doesn't contain null***");
        if(flag){
            result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    
    public void testSize(MyArrayList array, Results result){
        int before = array.size();
        array.insertSorted(50);
        array.insertSorted(60);
        int after = array.size();
        result.storeNewResult("***total number of elements increases after adding the values into the array***");
        if(after>before){
             result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    
    public void testSum(MyArrayList array, Results result){
        int before = array.sum();
        array.removeValue(50);
        array.removeValue(40);
        int after = array.sum();
        result.storeNewResult("***sum of all the elements of the array is decreased after removing few elements***");
        if(after>before){
             result.storeNewResult("fail");
        }
        else{
            result.storeNewResult("pass");
        }
        result.writeToFile(result.getResult());
    }
    
    public void Indexof2(MyArrayList array, Results result){
        array.insertSorted(98);
        result.storeNewResult("***IndexOf returns the correct index if the value exists***");
        if(array.indexOf(98)!=-1){
             result.storeNewResult("Pass");
        }
        else{
            result.storeNewResult("Fail");
        }
        result.writeToFile(result.getResult());
    }
    
    
    public void testPrintInsertion2(MyArrayList array, Results result){
        array.insertSorted(91);
        array.insertSorted(92);
        array.removeValue(91);
        
        boolean flag = array.getHash_arr().containsValue(91);
        result.storeNewResult("***After removing a value from an array, it is also removed from the data structure***");
        if(flag){
             result.storeNewResult("Fail");
        }
        else{
            result.storeNewResult("Pass");
        }
        result.writeToFile(result.getResult());
    }
    
}
