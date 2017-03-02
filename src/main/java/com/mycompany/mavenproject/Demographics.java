package com.mycompany.mavenproject;

import java.io.Serializable;

public class Demographics implements Serializable {

    private String Name;
    private String City;
    private String Country;

    public String getName() {
        return Name;
    }

    public String getCity() {
        return City;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCountry() {
        return Country;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name=" + getName() + "\n");
        sb.append("City=" + getCity() + "\n");
        sb.append("Country=" + getCountry() + "\n");

        return sb.toString();
    }
}
