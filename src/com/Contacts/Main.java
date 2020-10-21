package com.Contacts;


public class Main {

    public static void main(String[] args) {
        ContactsBook book = new ContactsBook();

        while(!book.isExit()) {
            book.openMenu();
            switch(book.getInput()) {
                case "add":
                    book.add();
                    break;
                case "remove":
                    book.remove();
                    break;
                case "edit":
                    book.edit();
                    break;
                case "count":
                    book.count();
                    break;
                case "list":
                    book.list();
                    break;
                case "exit":
                    book.exit();
                    break;
                default:
                    System.out.println("I don't know this word!");
                    break;
            }
        }
    }
}
