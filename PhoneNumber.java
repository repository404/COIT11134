/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.staffphonebook;

/**
 *
 * @author kenzlerb
 */
public class PhoneNumber {

    private String name;
    private String phoneNo;

    public PhoneNumber(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return getName() + ",  " + getPhoneNo();
    }
    
}

