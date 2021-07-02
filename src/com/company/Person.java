package com.company;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String personName;
    List<String> hourIn = new ArrayList<String>();
    List<String> hourOut = new ArrayList<String>();

    public Person insertHourIn(String personName, String hourIn) {
        this.personName = personName;
        this.hourIn.add(hourIn);
        return this;
    }

    public Person insertHourOut(String personName, String hourOut) {
        this.personName = personName;
        this.hourOut.add(hourOut);
        return this;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<String> getHourIn() {
        return hourIn;
    }

    public void setHourIn(String hourIn) {
        this.hourIn.add(hourIn);
    }

    public List<String> getHourOut() {
        return hourOut;
    }

    public void setHourOut(String hourOut) {
        this.hourOut.add(hourOut);
    }
}
