package com.workintech.library.people;

import com.workintech.library.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {

    private List<Book> borrowedBooks;
    private static final int DEFAULT_BORROW_LIMIT = 5;
    private int borrowLimit;

    public Reader(String firstName, String lastName) {
        super(firstName, lastName);
        this.borrowedBooks = new ArrayList<>();
        this.borrowLimit = DEFAULT_BORROW_LIMIT;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void borrowBook(Book book) {
        if(book.isAvailable()){
            if(borrowedBooks.size() < borrowLimit){
                borrowedBooks.add(book);
                book.setAvailable(false);
                System.out.println("Book borrowed: " + book.getTitle());
                borrowLimit--;
            } else {
                System.out.println("Borrow limit reached. Can't borrow more books.");
            }
        } else {
            System.out.println("This book is already borrowed by another reader");
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
        System.out.println("Book returned: " + book.getTitle());
        borrowLimit++;
    }

    public void showBorrowedBooks(){
        if (borrowedBooks.isEmpty()){
            System.out.println("No books borrowed by " + getFirstName() + " " + getLastName());
        } else {
            System.out.println("Books borrowed by " + getFirstName() + " " + getLastName() + ":");
            for (Book book: borrowedBooks){
                System.out.println("- " + book.getTitle());
            }
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am a reader and my name is " + getFirstName() + " " + getLastName());
    }
}
