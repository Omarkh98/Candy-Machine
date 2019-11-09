/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candymachine;

public class Dispenser {
    
    private int NumberOfItems;  
    private int ProductCost;
    private String ProductName;
    private String[] ProductPackingBoxType = {"Pink Box", "Black Box", "Cartoonish Box"};
    
public Dispenser() {
}

public Dispenser(String setProductName, int setNoOfItems, int setCost) {  
   NumberOfItems = setNoOfItems;  
   ProductCost = setCost; 
   ProductName = setProductName;
}

public int getNumberOfItems() {
   return NumberOfItems; 
}
public int getProductCost() {
   return ProductCost;
}

public String getProductName() {
    return ProductName;
}

public String GetProductPackingBoxColor(int Index) {
    return ProductPackingBoxType[Index];
}

public void makeSale() {
   NumberOfItems--;
}   

}
