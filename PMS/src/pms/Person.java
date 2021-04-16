/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author M_Khuzaima
 */
public class Person {
    private String name;
    private String email;
    private String address;
    private String password;
    private String id = "";
    private String cnic;
    private String gender;
    private Date joiningDate;
    private String contactNumber;

    public String getContactNumber() {
        return contactNumber;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }

    public boolean setContactNumber(String contactNumber) {
        
        int size = contactNumber.length();
        if (size != 11) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {
            char ch = contactNumber.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        
        this.contactNumber = contactNumber;
        return true;
    }
    
    public String getJoiningDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.format(this.joiningDate);
    }

    public void setJoiningDate(Date joiningDate) {
        
        this.joiningDate = joiningDate;
    }
    
    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                    || ch == ' ')) {
                return false;
            }
        }
        
        this.name = name;
        return true;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        
        int size = email.length();
        
        if (size == 0)
            return false;
        
        String [] arr = email.split("@");
        if (arr.length != 2) {
            return false;
        }
        
        size = arr[0].length();
        if (size == 0)
            return false;
        
        for (int i = 0; i < size; i++) {
            char ch = arr[0].charAt(i);
            if(!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        
        size = arr[1].length();
        if (size == 0)
            return false;
        
        for (int i = 0; i < size; i++) {
            char ch = arr[1].charAt(i);
            if(!(Character.isLetter(ch) || ch == '.')) {
                return false;
            }
        }
        this.email = email;
        return true;
    }


    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        
        int size = address.length();
        if(size == 0) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {
            char ch = address.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || ch == '#' || ch == '-' ||
                    ch == ' ' || ch == ',' || ch == '.' )) {
                return false;
            }
        }
        
        this.address = address;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getCnic() {
        return cnic;
    }

    public boolean setCnic(String cnic) {
        
        int size = cnic.length();
        if (size != 13) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {
            char ch = cnic.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        
        this.cnic = cnic;
        return true;
    }
    
}
