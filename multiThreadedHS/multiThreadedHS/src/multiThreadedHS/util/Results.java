/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_assign_4.multiThreadedHS.src.multiThreadedHS.util;

/**
 *
 * @author dheer
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dheer
 */
public class Results implements FileDisplayInterface{
    private String path, result="";
    
   private ArrayList<Integer> arr = new ArrayList<>();

    /**
     *
     * @param value
     */
    public synchronized void setArr(int value) {
        arr.add(value);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Integer> getArr() {
        return arr;
    }
    
    BufferedWriter writer;
   
    /**
     *
     * @param res
     */
    public void storeNewResult(int res){
        result+= res + "\n";    
    }

    /**
     *
     * @return
     */
    public String getResult(){
        return result;
    }

    /**
     *
     * @param filePath
     */
    public void setPath(String filePath){
        path=filePath;
    }

    /**
     *
     */
    @Override
    public void writeToFile() {  
        try {
             writer = new BufferedWriter(new FileWriter(path));
             writer.append(result);
             writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
