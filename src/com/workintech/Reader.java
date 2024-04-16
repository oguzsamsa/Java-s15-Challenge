package com.workintech;

import java.util.List;

public class Reader extends Person {
    private List<Book> books;
    private List<Book> purchasedBooks;
    private List<Book> borrowedBooks;

    public Reader(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a reader and my name is: " + getFirstName() + " " + getLastName());
    }

    public void showBooks(){

    }


}
