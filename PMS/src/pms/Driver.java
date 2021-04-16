/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tempslate file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
//import sun.security.jca.GetInstance;

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
        
        FileReader fr;
        BufferedReader br;
        
        try {
            fr = new FileReader("person.txt");
            br = new BufferedReader(fr);
            
            String line = br.readLine();
            while(line!= null) {
                
                String [] arr = line.split(";");
                if (arr.length == 6) {
                    Person person;
                    if (arr[1].startsWith("EMP")) {
                        Employee employee = new Employee();
                        employee.setName(arr[0]);
                        employee.setId(arr[1]);
                        employee.setContactNumber(arr[2]);
                        employee.setEmail(arr[3]);
                        employee.setCnic(arr[4]);
                        employee.setAddress(arr[5]);
                        Driver.getInstance().addEmployee(employee);
                    }
                    else {
                        Manager manager = new Manager();
                        manager.setName(arr[0]);
                        manager.setId(arr[1]);
                        manager.setContactNumber(arr[2]);
                        manager.setEmail(arr[3]);
                        manager.setCnic(arr[4]);
                        manager.setAddress(arr[5]);
                        Driver.getInstance().addManager(manager);
                    }
                    
                }
                
                line = br.readLine();
            }
            
            br.close();
            fr.close();
        
        } catch (Exception e) {
            System.out.println("Failed to load Employee/Manager Data");
        }
        
        try {
            fr = new FileReader("items.txt");
            br = new BufferedReader(fr);
            
            String line = br.readLine();
            while (line != null) {
                
                String [] arr = line.split(";");
                if (arr.length == 4) {
                    Item item = new Item();
                    item.setId(arr[0]);
                    item.setName(arr[1]);
                    item.setQuantity(arr[2]);
                    item.setConsumable(arr[3] == "true");
                    Driver.getInstance().addItem(item);
                }
                
                
                line = br.readLine();
            }
            br.close();
            fr.close();
            
        } catch (Exception ex) {
            System.out.println("Failed to load data of the items.");
//            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LoginForm frame = new LoginForm();
        frame.setVisible(true);
    }
    
    private Administrator administrator;

    private ArrayList<Manager> managers;
    private ArrayList<Employee> employees;
    private ArrayList<Item> items;
    
    private Driver() {
        managers = new ArrayList<>();
        employees = new ArrayList<>();
        items = new ArrayList<>();
        administrator = new Administrator();
    }
    
    private static Driver instance;

    public static Driver getInstance() {
        
        if(instance == null) {
            instance = new Driver();
            return instance;
        }
        
        return instance;
    }
    
    
    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }
    
    public void addManager(Manager manager) {
        manager.setJoiningDate(new Date());
        if (manager.getId() == null) {
            manager.setId();
        }
        this.managers.add(manager);
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId();
        }
        employee.setJoiningDate(new Date());
        this.employees.add(employee);
        
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    public void addItem(Item item) {
        if (item.getId() == null) {
            item.setId();
        }
        this.items.add(item);
    }
    
    
}
