package com.workintech;

import java.util.List;

public class Author extends Person{
    private List<Book> books;
    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an author and my name is " + getFirstName() + " " + getLastName());
    }

    public void showBooks(){
        System.out.println(getFirstName() + " " + getLastName() + "'s books are: " + books);
    }

    public void newBook(Book book){
        books.add(book);
    }
}
