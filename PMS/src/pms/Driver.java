/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tempslate file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.util.ArrayList;
import sun.security.jca.GetInstance;

/**
 *
 * @author M_Khuzaima
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LoginForm frame = new LoginForm();
        frame.setVisible(true);
    }

    
    private ArrayList<Manager> managers;
    private ArrayList<Employee> employees;
    private ArrayList<Item> items;
    
    private Driver() {
        managers = new ArrayList<>();
        employees = new ArrayList<>();
        items = new ArrayList<>();
    }
    
    private static Driver instance;

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }
    
    public void addManager(Manager manager) {
        
        this.managers.add(manager);
    }

    public static Driver getInstance() {
        
        if(instance == null) {
            instance = new Driver();
            return instance;
        }
        
        return instance;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    
    
    
}
