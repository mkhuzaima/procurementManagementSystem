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
class Employee extends Person {
    
    private int requestedItems = 0;

    public int getRequestedItems() {
        return requestedItems;
    }

    public void setRequestedItems(int requestedItems) {
        this.requestedItems = requestedItems;
    }
    
    
    private static int number = 0;
    
    public void setId() {
        number++;
        super.setId("EMP-" + number);
    }
    
    public void requestItem() {
        
    }
    
    public void viewRequestItems() {
        
    }
    
    public void viewIssuedItems() {
        
    }

    public Employee() {
        this.setPassword("Employee");
    }
    
    
} 
