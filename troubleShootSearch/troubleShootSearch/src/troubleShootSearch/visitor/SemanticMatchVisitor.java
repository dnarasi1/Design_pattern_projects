/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor;

import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products.ProductI;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.FileProcessor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.MyLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author dheer
 */
public class SemanticMatchVisitor implements VisitorI {

    String input = "";
    String storeRes = "";
    
    private HashMap<String, String> syn = new HashMap<>();
    private String temp1 = "";
    private String message;
    private String message2;

    /**
     *
     * @param products
     */
    @Override
    public void visit(ProductI products) {

        String line = products.getFileS().readline();
        
        while (line != null) {
            String[] tokens = line.split(":");
            String key1 = tokens[0];
            String value1 = tokens[1];
            syn.put(key1, value1);
            line = products.getFileS().readline();
        }
        for (int j = 0; j < products.getArray().size(); j++) {
            input = products.getArray().get(j);
            Iterator it = syn.entrySet().iterator();
            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();
                if (pair.getKey().equals(input)) {
                    temp1 = (String) pair.getValue();
                } else if (pair.getValue().equals(input)) {
                    temp1 = (String) pair.getKey();
                }
            }

            for (int i = 0; i < products.getProduct().size(); i++) {
                if(temp1.equals(""))
                    continue;
                if ((products.getProduct().get(i).contains(temp1)) ) {
                    storeRes=products.getProduct().get(i) + "\n";
                    products.getResult().storeNewResult(storeRes);
                    products.getResult().writeToFile();
                    MyLogger.writeMessage(storeRes, MyLogger.DebugLevel.SEARCH_RESULTS);
                    message = "SemanticMatchVisitor method called";
                    MyLogger.writeMessage(message, MyLogger.DebugLevel.VISITOR);
                    message2 = "Entry has been made to the result";
                    MyLogger.writeMessage(message2, MyLogger.DebugLevel.IN_RESULTS);
                } else {
                    
                }
                
            }
            
        }
        
    }

}
