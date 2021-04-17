/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M_Khuzaima
 */
public class RequestRecord {
    
    private Date requestDate = null;
    private String employeeId;
    private String itemId;
    private int quantity;

    public void setRequestDate() {
        this.requestDate = new Date();
    }
    
    public boolean setRequestDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            this.requestDate = sdf.parse(date);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public boolean setEmployeeId(String employeeId) {
        for (Employee employee : Driver.getInstance().getEmployees()) {
            if (employee.getId().equals(employeeId)) {
                this.employeeId = employeeId;
                return true;
            }
        }
        return false;
    }

    public boolean setItemId(String itemId) {
        for (Item item : Driver.getInstance().getItems()) {
            if (item.getId().equals(itemId)) {
                this.itemId = itemId;
                return true;
            }
        }
        return false;

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

    public String getRequestDate() {
        if (requestDate == null) {
            return null;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.format(requestDate);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}
