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

    public void addBook(Book book){
        books.add(book);
        System.out.println("The book " + book.getTitle() + " successfully added to library!");
    }


    public void borrowBook(Reader reader, Book book){
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
    public Book selectBookById(int id) {
        for (Book book: books) {
            if(book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Book selectBookByName(String name) {
        for (Book book: books) {
            if(book.getTitle().equalsIgnoreCase(name)) {
                return book;
            }
        }

        return null;
    }

    @Override
    public List<Book> selectBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book: books){
            if(book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
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
}
