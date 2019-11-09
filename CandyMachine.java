/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candymachine;

import static candymachine.Chips.SauceType;
import static java.lang.System.exit;
import java.util.HashMap;
import java.util.Scanner;

public class CandyMachine {

    public static Scanner SC = new Scanner(System.in);
    public static Chips CH = new Chips();
    public static HashMap <String,Integer> SauceType = new HashMap <String,Integer>();
    public static int BoxChoice;
    public static int MyChoice;
    public static int SauceChoice;
    public static int Sauce;
    
    public static void main(String[] args) {
        CashRegister CR = new CashRegister();
        Dispenser PopCorn = new Dispenser("PopCorn",50,65);
        Dispenser Cookies = new Dispenser("Cookies",50,70);
        Dispenser Chips = new Dispenser("Chips",50,95);
        
        
        System.out.println("***Welcome To Our Candy Shop***");
        System.out.println(CR.toString());
        System.out.println(CR.Options());
        
        
        MyChoice = SC.nextInt();
        
        while(MyChoice != 9) {
            switch(MyChoice) {
                
            case 1:
                Purchase(CR,PopCorn);
                break;
            case 2:
                Purchase(CR,Cookies);
                break;

            case 3:
                Purchase(CR,Chips);
                break;

            default:
                System.out.println("Product Unavailable");
            }
        }
    }
    public static void Purchase(CashRegister Cash, Dispenser Product) {
        
        int Price;
        int Payment;
        int Inserted;
        int Change = 0;
        String Name = "";
        String Box;
        int ChipsPrice = 95;
        
        if(MyChoice == 3) {  // Sauce Time.
            SauceType.put("Ranch Sauce",20);
            SauceType.put("Ketchup",5);
            SauceType.put("Original",0);
         
            System.out.println(Cash.Sauce());
            SauceChoice = SC.nextInt();

            if(SauceChoice == 1) {
               Sauce = SauceType.get("Ranch Sauce");
               Sauce += ChipsPrice;
            } 
            else if (SauceChoice == 2){
               Sauce = SauceType.get("Ketchup");
               Sauce += ChipsPrice;
            }
            else if (SauceChoice == 3){
               Sauce = SauceType.get("Original");
               Sauce += ChipsPrice;
            }
            else {
                System.out.println("Sauce Chosen Is Unavailable");
                return;
            }
        }
        
        if(Product.getNumberOfItems() > 0) {
            Price = Product.getProductCost();
            Inserted = 0;
            
            if(Price > 0) {
                if(MyChoice == 3){
                    System.out.println(Cash.PleasePay(Sauce));
                    Payment = SC.nextInt();
                    Inserted += Payment;
                if(Inserted < Sauce) {
                    System.out.println("We can't sell for you.\n" + "As you didn't pay the required coins!");
                    exit(0);
                }
                Change = Math.abs(Sauce - Inserted);  // Returning The Change.
                Cash.acceptAmount(Inserted);
                Product.makeSale();
                }
                
                if(MyChoice == 1 || MyChoice == 2){
                System.out.println(Cash.PleasePay(Price));
                Payment = SC.nextInt();
                Inserted += Payment;
                if(Inserted < Price) {
                    System.out.println("We can't sell for you.\n" + "As you didn't pay the required coins!");
                    exit(0);
                }

            Change = Math.abs(Price - Inserted);  // Returning The Change.
            Cash.acceptAmount(Inserted);
            Product.makeSale();
                }           
            System.out.println(Cash.PackingBox());
            BoxChoice = SC.nextInt();
            
            if(BoxChoice == 1) {
               Box = Product.GetProductPackingBoxColor(0);               
            } 
            else if (BoxChoice == 2){
               Box = Product.GetProductPackingBoxColor(1);
            }
            else if (BoxChoice == 3){
               Box = Product.GetProductPackingBoxColor(2);
            }
            else {
                System.out.println("Backing Box Unavailable");
                return;
            }
                
            Name = Product.getProductName();
            
            System.out.println(Cash.Boxing(Name,Box));
            System.out.println(Cash.Change(Change));
            exit(0);
        }
    }
        else {
            System.out.println("Sorry this item is sold out."); 
    }
  }
}

