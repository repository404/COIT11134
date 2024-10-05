/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.staffphonebook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author kenzlerb
 */
public class DataHandler {

    private String fileName;
    private ArrayList<PhoneNumber> phoneNoList;

    //constructor takes a file name as input, invoke readDataFile
    public DataHandler(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        //initialise phoneNo ArrayList
        this.phoneNoList = new ArrayList<PhoneNumber>();
        //reading all saved phone numbers
        readDataFile();
    }

    //Private method for reading all saved phone numbers from the text file 
    //and uploading to the phoneNo ArrayList
    //Not accessible to the external classes
    private void readDataFile() throws FileNotFoundException {
        try {
            Scanner in = new Scanner(new FileReader(fileName)); //open file
            String myEntry = "";
            String name = "";
            String phone = "";

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");

                while (st.hasMoreTokens()) {
                    name = st.nextToken();
                    phone = st.nextToken();
                }
                // Add phone number to the PhoneNo ArrayList
                PhoneNumber ph = new PhoneNumber(name, phone);
                phoneNoList.add(ph);

            } // end of while loop
            in.close(); //close file
        } catch (ArrayIndexOutOfBoundsException ex) {
            //...
        } catch (FileNotFoundException ex) {
            //...
        }
    }//end of the readDataFile method

    //Method for saving all phone numbers from the phoneNo ArrayList to the text file
    public void saveData() {
        try {
            Formatter out = new Formatter(fileName);    //open file
            int totalNumbers = phoneNoList.size();
            for (int i = 0; i < totalNumbers; i++) {
                PhoneNumber curPhoneNo = phoneNoList.get(i);
                out.format("%s\n", curPhoneNo.toString());
            }
            out.close(); //close file
        } catch (SecurityException ex) {
            //....
        } catch (FileNotFoundException ex) {
            //...
        }
    } //end of the SaveData method 

    // Method for adding a phone number to the phoneNo ArrayList
    public void addPhoneNo(PhoneNumber ph) {
        phoneNoList.add(ph);
    }

    //Method for creating a String containing all phone number entries
    //The String would be displayed in the text area on the Main scene  
    public String getDisplayOutput() {
        String allPhone = "";     // to store all name and phone as a single String literal 
        int count = phoneNoList.size(); // total number of entries
        for (int i = 0; i < count; i++) {
            PhoneNumber curPhoneNo = phoneNoList.get(i);
            allPhone += curPhoneNo.toString() + "\n";
        }
        return allPhone + "\n" + "Total number of phone entry is: " + count;
    }
}
