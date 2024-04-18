import com.workintech.library.Library;
import com.workintech.library.book.Book;
import com.workintech.library.book.BookCategory;
import com.workintech.library.people.Author;
import com.workintech.library.people.Reader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Library library = new Library();
        Book book = new Book(1,"Dune", new Author("Frank","Herbert"), BookCategory.SCIENCE_FICTION,true);
        Reader reader = new Reader("Oğuz", "Samsa");
        library.addBook(book);
        library.addReader(reader);
        library.borrowBook(reader,book);
        reader.showBorrowedBooks();

    }
}