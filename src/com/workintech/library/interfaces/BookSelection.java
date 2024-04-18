package com.workintech.library.interfaces;

import com.workintech.library.book.Book;
import com.workintech.library.people.Author;

import java.util.List;

public interface BookSelection {
    Book selectBookById(int id);
    Book selectBookByName(String name);
    List<Book> selectBooksByAuthor(Author author);

}
