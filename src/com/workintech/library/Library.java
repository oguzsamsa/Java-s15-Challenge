package com.workintech.library;

import com.workintech.library.book.Book;
import com.workintech.library.book.BookCategory;
import com.workintech.library.interfaces.BookListing;
import com.workintech.library.interfaces.BookSelection;
import com.workintech.library.people.Author;
import com.workintech.library.people.Reader;


import java.util.*;

public class Library implements BookSelection, BookListing {
    private Set<Reader> readers;
    private List<Book> books;
    private Map<Book, Reader> borrowedBooksMap;

    public Library() {
        this.readers = new HashSet<>();
        this.books = new ArrayList<>();
        this.borrowedBooksMap = new HashMap<>();
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<Book, Reader> getBorrowedBooksMap() {
        return borrowedBooksMap;
    }

    public void setBorrowedBooksMap(Map<Book, Reader> borrowedBooksMap) {
        this.borrowedBooksMap = borrowedBooksMap;
    }

    public void addReader(Reader reader){
        readers.add(reader);
        System.out.println(reader.getFirstName() + " " + reader.getLastName() + " successfully added to library database!");
    }

    public void addBook(Book newBook){
        if(!books.contains(newBook)){
            books.add(newBook);
            System.out.println("The book " + newBook.getTitle() + " successfully added to library!");
        } else {
            System.out.println("The book " + newBook.getTitle() + " is already in the library!");
        }

    }

    public void addBooks(Book... newBooks) {
        for (Book book : newBooks) {
            if (!books.contains(book)) {
                books.add(book);
                System.out.println("The book " + book.getTitle() + " successfully added to the library!");
            } else {
                System.out.println("The book " + book.getTitle() + " is already in the library!");
            }
        }
    }


    public void borrowBook(Reader reader, Book book){
        if(!readers.contains(reader)){
            System.out.println("This reader is not registered in the library system. Please register first.");
            return;
        }
        if(reader.getBorrowLimit() <= 0){
            System.out.println("Borrow limit reached. " + reader.getFirstName() + " " + reader.getLastName() + " can't borrow more books.");
            return;
        }
        if (books.contains(book) && book.isAvailable()){
            reader.borrowBook(book);
            borrowedBooksMap.put(book,reader);
            System.out.println(book.getTitle() + " is borrowed by " + reader.getFirstName() + " " + reader.getLastName() + " successfully.");
        } else {
            System.out.println("This book is not available for borrowing");
        }
    }

    public void returnBook(Book book){
        Reader reader = borrowedBooksMap.remove(book);
        if (reader!=null){
            reader.returnBook(book);
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book was not borrowed from this library");
        }
    }


    @Override
    public void selectBookById(int id) {
        for (Book book: books) {
            if(book.getId() == id) {
                System.out.println("Book by the id number " + id + " is " + book.getTitle());
            } else {
                System.out.println("There is no book registered on this id(#" + id + ")");
            }
        }


    }

    @Override
    public void selectBookByName(String name) {
        for (Book book: books) {
            if(book.getTitle().equalsIgnoreCase(name)) {
                System.out.println("The details of the book named " + name + " are as follows: " + book);
            } else {
                System.out.println("There is no book under this name");
            }
        }


    }




    @Override
    public void listBooksByCategory(BookCategory category) {
        List<Book> booksByCategory = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory() == category) {
                booksByCategory.add(book);
            }
        }

        if (booksByCategory.isEmpty()) {
            System.out.println("No books were found in the specified category.");
        } else {
            System.out.println("Books in category " + category + ":");
            for (Book book: booksByCategory){
                System.out.println("- " + book.getTitle());
            }
        }
    }

    @Override
    public void listBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }

        if (booksByAuthor.isEmpty()) {
            System.out.println("No books were found by the specified author");
        } else {
            System.out.println("Books by author " + author.getFirstName() + " " + author.getLastName() + ":");
            for (Book book: booksByAuthor){
                System.out.println("- " + book.getTitle());
            }
        }
    }

    public void displayBorrowedBooks(){
        if(borrowedBooksMap.isEmpty()){
            System.out.println("No books are currently borrowed from the library");
        } else {
            System.out.println("Borrowed books:");
            for(Map.Entry<Book, Reader> entry: borrowedBooksMap.entrySet()){
                Book book = entry.getKey();
                Reader reader = entry.getValue();
                System.out.println("- Book Title: " + book.getTitle() + ", Borrowed by: " + reader.getFirstName() + " " + reader.getLastName());
            }
        }
    }
}
