package com.example.postmidtermphonebook;

public class ContactModal {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private int id;

    // creating getter and setter methods
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void
    setAddress(String address)
    {
        this.address = address;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public ContactModal(String firstName,
                       String lastName,
                       String phoneNumber,
                       String address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
