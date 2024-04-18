package com.workintech.library.interfaces;

import com.workintech.library.book.BookCategory;
import com.workintech.library.people.Author;

public interface BookListing {
    void listBooksByCategory(BookCategory category);
    void listBooksByAuthor(Author author);
}
