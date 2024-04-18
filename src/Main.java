import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.book.BookCategory;
import com.workintech.library.people.Author;
import com.workintech.library.people.Reader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our library!");

        Library library = new Library();
        Author frankHerbert = new Author("Frank", "Herbert");
        Book book1 = new Book(1, "Dune", frankHerbert, BookCategory.SCIENCE_FICTION, true);
        Author georgeOrwell = new Author("George", "Orwell");
        Book book2 = new Book(2, "1984", georgeOrwell , BookCategory.SCIENCE_FICTION, true);
        Author fScottFitzgerald = new Author("F. Scott", "Fitzgerald");
        Book book3 = new Book(3, "The Great Gatsby", fScottFitzgerald , BookCategory.NOVEL, true);
        Author harperLee = new Author("Harper", "Lee");
        Book book4 = new Book(4, "To Kill a Mockingbird", harperLee , BookCategory.NOVEL, true);
        Author danBrown = new Author("Dan", "Brown");
        Book book5 = new Book(5, "The Da Vinci Code", danBrown , BookCategory.MYSTERY_CRIME, true);
        Author arthurConanDoyle = new Author("Arthur Conan", "Doyle");
        Book book6 = new Book(6, "Sherlock Holmes: The Complete Novels and Stories", arthurConanDoyle , BookCategory.MYSTERY_CRIME, true);
        Author yuvalNoahHarari = new Author("Yuval Noah", "Harari");
        Book book7 = new Book(7, "Sapiens: A Brief History of Humankind", yuvalNoahHarari , BookCategory.HISTORY, true);
        Author stephenHawking = new Author("Stephen", "Hawking");
        Book book8 = new Book(8, "A Brief History of Time", stephenHawking , BookCategory.SCIENCE_FICTION, true);
        Author fyodorDostoevsky = new Author("Fyodor", "Dostoevsky");
        Book book9 = new Book(9, "Crime and Punishment", fyodorDostoevsky , BookCategory.NOVEL, true);
        Author plato = new Author("Plato","");
        Book book10 = new Book(10, "The Republic", plato , BookCategory.PHILOSOPHY, true);

        Reader reader = new Reader("Oğuz", "Samsa");
        Reader reader2 = new Reader("Ali", "Veli");
        Reader reader3 = new Reader("Ahmet", "Mehmet");


        library.addBook(book1);
        library.addBooks(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);

        library.listBooksByCategory(BookCategory.NOVEL);

        library.listBooksByAuthor(new Author("George", "Orwell"));

        library.borrowBook(reader, book1);
        library.addReader(reader);
        library.borrowBook(reader, book1);
        library.addReader(reader2);
        library.addReader(reader3);
        library.borrowBook(reader, book2);
        library.borrowBook(reader3, book3);
        library.borrowBook(reader, book4);
        library.borrowBook(reader2, book4);
        library.returnBook(book4);
        library.borrowBook(reader2,book4);
        reader.showBorrowLimit();
        reader2.showBorrowLimit();
        reader3.showBorrowLimit();
        reader.showBorrowedBooks();
        reader2.showBorrowedBooks();
        reader3.showBorrowedBooks();
        library.displayBorrowedBooks();
        library.borrowBook(reader, book7);
        library.borrowBook(reader, book8);
        library.borrowBook(reader,book10);
        reader.showBorrowLimit();
        library.borrowBook(reader, book5);
        library.returnBook(book8);
        library.borrowBook(reader,book5);

        frankHerbert.showBooks();
        plato.showBooks();





    }
}