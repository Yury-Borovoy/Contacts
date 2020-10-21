package com.Contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String number;
    private String name;
    private String surname;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = checkPhoneNumber(number);
    }

    private String checkPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("\\+?\\([0-9a-zA-Z]+\\)|" +
                        "\\+?[0-9a-zA-Z]+|" +
                        "\\+?[0-9a-zA-Z]+[\\s-]\\([0-9a-zA-Z]{2,}\\)([\\s-][0-9a-zA-Z]{2,})*|" +
                        "\\+?\\([0-9a-zA-Z]+\\)[\\s-][0-9a-zA-Z]{2,}([\\s-][0-9a-zA-Z]{2,})*|" +
                        "\\+?[0-9a-zA-Z]+[\\s-][0-9a-zA-Z]{2,}([\\s-][0-9a-zA-Z]{2,})*|"
                , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        boolean result = matcher.matches();
        if (result) {
            return number;
        }
        System.out.println("Wrong number format!");
        return "[no number]";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = checkPhoneNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

