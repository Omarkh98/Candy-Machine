/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candymachine;
import java.util.HashMap;

public class Chips extends Dispenser {
   
public static HashMap <String,Integer> SauceType = new HashMap <String,Integer>();

public Chips() {
    SauceType.get("Ranch Sauce");
}
public Chips(String SauceName,int key) {
         SauceType.put("Ranch Sauce",20);
         SauceType.put("Ketchup Sauce",5);
         SauceType.put("Original Sauce",0);  
}
   
public int Ranch(){
    return SauceType.get("Ranch Sauce");
}
   
    @Override
    public int getProductCost() {
        return super.getProductCost()+SauceType.get("Ranch Sauce");  
    }
}
