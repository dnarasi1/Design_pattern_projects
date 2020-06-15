package dheeraj_deshmudre_assign_1.myArrayList.src.myArrayList.util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class FileProcessor {
    
    FileReader file;
    BufferedReader reader;

    public FileProcessor(String path) throws IOException {
        try {
            reader =new BufferedReader(new FileReader(path));    
        } 
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage() + "error");
        }
       
    }
    public String readine(){
        try {
            //String line = null;
            
            //while((line = reader.readLine())!= null) {
            return reader.readLine();
            
            
            //return null;
        } catch (IOException ex) {
            Logger.getLogger(FileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

