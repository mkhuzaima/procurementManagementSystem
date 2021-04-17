/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tempslate file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        
        try {
            fr = new FileReader("requestedData.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null) {
            
                String [] arr = line.split(";");
                if (arr.length == 4) {
                    RequestRecord requestRecord = new RequestRecord();
                    requestRecord.setEmployeeId(arr[0]);
                    requestRecord.setItemId(arr[1]);
                    requestRecord.setQuantity(arr[2]);
                    requestRecord.setRequestDate(arr[3]);
                    
                    Driver.getInstance().addRequest(requestRecord);
                
                }
                line = br.readLine();
            }
            br.close();
            fr.close();
//            for(RequestRecord rr : Driver.getInstance().getRequests()) {
//                System.out.println(rr.getItemId() + "__" + rr.getEmployeeId());
//            }
            
        } catch (Exception ex) {
            System.out.println("Failed to load Requst data.");
        }
        
        try {
            fr = new FileReader("issuedData.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                IssueRecord ir = new IssueRecord();
                String [] arr = line.split(";");
                if (arr.length == 5) {
                    ir.setManagerId(arr[0]);
                    ir.setEmployeeId(arr[1]);
                    ir.setItemId(arr[2]);
                    ir.setQuantity(arr[3]);
                    ir.setIssueDate(arr[4]);
                    Driver.getInstance().addIssueRecord(ir);
                }
                
                line = br.readLine();
            }
            
        } catch (Exception ex) {
            System.out.println("Failed to load Issued data");
        }
        
        
        
        LoginForm frame = new LoginForm();
        frame.setVisible(true);
    }
    
    public void saveData() {
        FileWriter fw;
        try {
            fw = new FileWriter("person.txt");
            
            for (Employee employee : Driver.getInstance().getEmployees()) {
                String str;
                str = String.format("%s;%s;%s;%s;%s;%s\n", employee.getName(),
                        employee.getId(), employee.getContactNumber(),
                        employee.getEmail(), employee.getCnic(),
                        employee.getAddress()
                );

                fw.write(str);
            }
            
            for (Manager manager : Driver.getInstance().getManagers()) {
                String str;
                str = String.format("%s;%s;%s;%s;%s;%s\n", manager.getName(),
                        manager.getId(), manager.getContactNumber(),
                        manager.getEmail(), manager.getCnic(),
                        manager.getAddress()
                );

                fw.write(str);
            }
            
            
            fw.close();

        } catch (IOException ex) {
            System.out.println("Error while writing employee data to file");
        }
        
        /*
            try {
            fw = new FileWriter("manager.txt");
            
            for (Manager manager : Driver.getInstance().getManagers()) {
            String str;
            str = String.format("%s;%s;%s;%s;%s;%s\n", manager.getName(),
            manager.getId(), manager.getContactNumber(),
            manager.getEmail(), manager.getCnic(),
            manager.getAddress());
            
            fw.write(str);
            }
            
            fw.close();
            } catch (IOException ex) {
            System.out.println("Error while writing manager data to file");
            }*/
        
        try {
            fw = new FileWriter("items.txt");
            
            for (Item item : Driver.getInstance().getItems()) {
                fw.write(item.getId() + ';' + item.getName() + ';'+ item.getQuantity() + ';'+ 
                        item.isConsumable() + '\n');
            }
            fw.close();
            
        } catch (IOException ex) {
            System.out.println("Failed to save data of the items.");
//            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fw = new FileWriter("requestedData.txt");
            for (RequestRecord requestRecord : Driver.getInstance().getRequests()) {
                fw.write(requestRecord.getEmployeeId() + ';' + 
                        requestRecord.getItemId() + ';' + 
                        requestRecord.getQuantity() + ';' +
                        requestRecord.getRequestDate()  + '\n'
                );
//                System.out.println(requestRecord.getEmployeeId() + ';' + 
//                        requestRecord.getItemId() + ';' + 
//                        requestRecord.getQuantity() + ';' +
//                        requestRecord.getRequestDate());
            }
            
            fw.close();
        } catch (Exception ex) {
            System.out.println("Failed to save Requst data.");
        }
        
        try {
            fw = new FileWriter("issuedData.txt");
            for (IssueRecord ir : Driver.getInstance().getIssueRecords()) {
                fw.write(ir.getManagerId() + ';' +
                        ir.getEmployeeId() + ';' + 
                        ir.getItemId() + ';' + 
                        ir.getQuantity() + ';' + 
                        ir.getIssueDate()  + '\n'
                );
            }
            fw.close();
        } catch (Exception ex) {
            System.out.println("Failed to save Issued data.");
        }
        
    }
    
    private Administrator administrator;

    private ArrayList<Manager> managers;
    private ArrayList<Employee> employees;
    private ArrayList<Item> items;
    private ArrayList<RequestRecord> requests;
    private ArrayList<IssueRecord> issueRecords;
    
    private Driver() {
        managers = new ArrayList<>();
        employees = new ArrayList<>();
        items = new ArrayList<>();
        requests = new ArrayList<>();
        issueRecords = new ArrayList<>();
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
    
    public void editManager(int index, Manager manager) {
//        int index = searchManagerById(id);
        if (index != -1) 
            this.managers.set(index, manager);
    }
    
    public int searchManagerById(String id) {
        int i = 0;
        for (Manager manager : Driver.getInstance().getManagers()) {
            if (manager.getId().equals(id)) {
                return i;
            }
            i++;
        }

        return -1;
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

    public ArrayList<RequestRecord> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<RequestRecord> requests) {
        this.requests = requests;
    }
    
    public void addRequest (RequestRecord requestRecord) {
        if (requestRecord.getRequestDate() == null) {
            requestRecord.setRequestDate();
        }
        this.requests.add(requestRecord);
    }

    public ArrayList<IssueRecord> getIssueRecords() {
        return issueRecords;
    }

    public void setIssueRecords(ArrayList<IssueRecord> issueRecords) {
        this.issueRecords = issueRecords;
    }
    
    public void addIssueRecord (IssueRecord issueRecord) {
        for (Item it: Driver.getInstance().getItems()) {
            if (it.getId().equals(issueRecord.getItemId())) {
                int newQuantity = it.getQuantity() - issueRecord.getQuantity();
                if (newQuantity < 0) {
                    newQuantity = 0;
                }
                it.setQuantity(String.valueOf(newQuantity));
                break;
            }
        }
        if (issueRecord.getIssueDate() == null) {
            issueRecord.setIssueDate();
        }
        this.issueRecords.add(issueRecord);
    }
    
}
