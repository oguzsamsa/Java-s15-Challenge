package com.workintech.library.people;

import com.workintech.library.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{

    private List<Book> writtenBooks;
    public Author(String firstName, String lastName) {
        super(firstName, lastName);
        this.writtenBooks = new ArrayList<>();
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an author and my name is " + getFirstName() + " " + getLastName());
    }

    public void newBook(Book book){
        writtenBooks.add(book);
        System.out.println("New book added: " + book.getTitle());
    }

    public void showBooks(){
        if (writtenBooks.isEmpty()) {
            System.out.println("No books written by " + getFirstName() + " " + getLastName());
        } else {
            System.out.println("Books written by " + getFirstName() + " " + getLastName() + ":");
            for (Book book: writtenBooks){
                System.out.println("- " + book.getTitle());
            }
        }
    }
}
