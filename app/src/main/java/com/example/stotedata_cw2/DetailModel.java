package com.example.stotedata_cw2;


public class DetailModel {
    private String Id, Name, Dob, Email;
    public DetailModel(String Id, String Name, String Dob, String Email ) {
        this.Id = Id;
        this.Name=Name;
        this.Dob=Dob;
        this.Email=Email;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
