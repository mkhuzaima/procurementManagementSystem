/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

/**
 *
 * @author M_Khuzaima
 */
class Item {
    private String name;
    private int quantity;
    private boolean consumable;
    private String id;
    private static int number = 0;
    
    public String getId() {
        return id;
    }

    public void setId() {
        number++;
        id = "ITM-" + number;
    }
    

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        int size = name.length();
        
        if (size == 0)
            return false;
        
        for (int i = 0; i < size; i++) {
            char ch = name.charAt(i);
            if(!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')
                    || ch == ' ' || ch == '-' || ch == '\'')) {
                return false;
            }
        }
        
        this.name = name;
        return true;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean setQuantity(String quantity) {
        
        int number = 0;
        
        try {
            number = Integer.parseInt(quantity);
            if(number < 0) {
                return false;
            }
        
            this.quantity = number;
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }
    
    
    
}
