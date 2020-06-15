/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor;

import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products.ProductI;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.MyLogger;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Reference: https://stackoverflow.com/questions/25417363/java-string-contains-matches-exact-word

*/


/**
 *
 * @author dheer
 */
public class ExactMatchVisitor implements VisitorI {

    private String message;
    private String message2;
    String input = "";
    String storeRes = "";

    /**
     *
     * @param products
     */
    @Override
    public void visit(ProductI products) {
        
        for (int j = 0; j < products.getArray().size(); j++) {
            input = products.getArray().get(j);
            
            
            for (int i = 0; i < products.getProduct().size(); i++) {
                String pattern = "\\b"+input+"\\b";
                Pattern p=Pattern.compile(pattern);
                Matcher m=p.matcher(products.getProduct().get(i));
                if ((m.find())) {
                    storeRes=products.getProduct().get(i) + "\n";
                    products.getResult().storeNewResult(storeRes);
                    products.getResult().writeToFile();
                    MyLogger.writeMessage(storeRes, MyLogger.DebugLevel.SEARCH_RESULTS);
                    message = "ExactMatchVisitor method called";
                    MyLogger.writeMessage(message, MyLogger.DebugLevel.VISITOR);
                    message2 = "Entry has been made to the result";
                    MyLogger.writeMessage(message2, MyLogger.DebugLevel.IN_RESULTS);
                    
                } else {
                }

            }
            
        }
        
    }

}
