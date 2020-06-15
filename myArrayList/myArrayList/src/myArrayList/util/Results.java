package dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    
    BufferedWriter writer;
   
    public void storeNewResult(String res){
        result+=res+"\n";    
    }
    public String getResult(){
        return result;
    }
    public void setPath(String filePath){
        path=filePath;
    }
    @Override
    public void writeToFile(String s) {  
        try {
             writer = new BufferedWriter(new FileWriter(path));
             writer.append(s);
             writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
