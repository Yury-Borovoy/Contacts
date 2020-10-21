package com.Contacts;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactsBook {
    private final ArrayList<Contact> listOfContacts = new ArrayList<>();
    private final Scanner scan = new Scanner(System.in);
    private String input;
    private boolean exit = false;

    public void openMenu() {
        System.out.println("Enter action (add, remove, edit, count, list, exit):");
        input = scan.nextLine();
    }

    public void add() {
        System.out.println("Enter the name: ");
        String name = scan.nextLine();
        System.out.println("Enter the surname: ");
        String surname = scan.nextLine();
        System.out.println("Enter the number: ");
        String number = scan.nextLine();
        Contact contact = new Contact(name, surname, number);
        listOfContacts.add(contact);
        System.out.println("The record added.");
    }

    public void remove() {
        if (listOfContacts.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            for (int i = 0; i < listOfContacts.size(); i++) {
                System.out.printf("%d. %s %s, %s%n", i + 1, listOfContacts.get(i).getName(),
                        listOfContacts.get(i).getSurname(), listOfContacts.get(i).getNumber());
            }
            int number = Integer.parseInt(scan.nextLine());
            listOfContacts.remove(number - 1);
        }

    }

    public void edit() {
        if (listOfContacts.size() == 0) {
            System.out.println("No records to edit!");
            return;
        }
        for (int i = 0; i < listOfContacts.size(); i++) {
            System.out.printf("%d. %s %s, %s%n", i + 1, listOfContacts.get(i).getName(),
                    listOfContacts.get(i).getSurname(), listOfContacts.get(i).getNumber());
        }
        System.out.println("Select a record: ");
        int position = Integer.parseInt(scan.nextLine());
        System.out.println("Select a field (name, surname, number): ");
        String field = scan.nextLine();
        switch(field) {
            case "name":
                System.out.println("Enter name: ");
                listOfContacts.get(position - 1).setName(scan.nextLine());
                System.out.println("The record updated!");
                break;
            case "surname":
                System.out.println("Enter surname: ");
                listOfContacts.get(position - 1).setSurname(scan.nextLine());
                System.out.println("The record updated!");
                break;
            case "number":
                System.out.println("Enter number: ");
                listOfContacts.get(position - 1).setNumber(scan.nextLine());
                System.out.println("The record updated!");
                break;
            default:
                break;
        }
    }

    public void count() {
        if (listOfContacts.size() == 1) {
            System.out.printf("The Phone Book has %d record", listOfContacts.size());
        } else {
            System.out.printf("The Phone Book has %d records", listOfContacts.size());
        }
    }

    public void list() {
        for (int i = 0; i < listOfContacts.size(); i++) {
            System.out.printf("%d. %s %s, %s%n", i + 1, listOfContacts.get(i).getName(),
                    listOfContacts.get(i).getSurname(), listOfContacts.get(i).getNumber());
        }
    }

    public void exit() {
        exit = true;
    }


    public String getInput() {
        return input;
    }

    public boolean isExit() {
        return exit;
    }
}
