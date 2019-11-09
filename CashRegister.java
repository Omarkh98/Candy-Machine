/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candymachine;

public class CashRegister {
    
private int COH; 

public CashRegister() {
 COH = 500;  
}

public CashRegister(int CashIn) { 
    COH = CashIn;  
}

public int getCashOnHand() {
    return COH; 
}

public void acceptAmount(int AmountIn) { 
    COH = COH + AmountIn ;
}

public String toString() { 
    return( "With you Omar Khaled in your service, How can I help you?"); 
}

public String Options() {
    return ("To select an item, enter\n" +
"1 for Popcorn = 65 cents\n" +
"2 for Cookies = 70 cents\n" +
"3 for Chips = 95 cents");
}
public String PleasePay(int Coins) {
    return ("Please Pay " + Coins + " Cents");
}

public String Change(int Change) {
    return ("Change Back = " + Change + " Cents ");
}

public String PackingBox() {
    return ("In which packing box would you like your Chips?\n" +
"1 for a Pink box\n" +
"2 for a Black box\n" +
"3 for a Cartoonish box");
}

public String Sauce() {  
   return ("Which sauces you want?\n" +
          "1 for Ranch sauce = 20 cents\n" +
          "2 for Ketchup = 5 cents\n" +
          "3 for Original = 0 cents\n");
}

public String Boxing(String ProductName, String BoxType) {  
   return ("We have packed your " + ProductName + " in a " + BoxType + "\n" + " Collect your " + ProductName + " at the bottom and enjoy");
}
}
