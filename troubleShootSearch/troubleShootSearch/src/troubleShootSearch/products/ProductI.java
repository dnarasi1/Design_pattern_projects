/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.products;

import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.FileProcessor;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.util.Results;
import dheeraj_deshmudre_5.troubleShootSearch.src.troubleShootSearch.visitor.VisitorI;
import java.util.ArrayList;

/**
 *
 * @author dheer
 */
public interface ProductI {
    public ArrayList<String> getProduct();
    public Results getResult();
    public FileProcessor getFileS();
    public ArrayList<String> getArray();
    public void addLines();
    public void accept(VisitorI visitor);
}
