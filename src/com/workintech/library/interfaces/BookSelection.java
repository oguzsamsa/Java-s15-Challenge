package com.workintech.library.interfaces;

import com.workintech.library.book.Book;
import com.workintech.library.people.Author;

import java.util.List;

public interface BookSelection {
    void selectBookById(int id);
    void selectBookByName(String name);


}
