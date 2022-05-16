import java.util.*;
import org.apache.log4j.*;

public class Library {
    public static HashMap <String,Book> Booklist = new HashMap<String,Book>();

    static Logger log = Logger.getLogger(Library.class.getName());

    public void return_book(Book book){
        if (Booklist.containsKey(book.book_id)){
            Book update = Booklist.get(book.book_id);
            update.book_count+= book.book_count;
            Booklist.put(book.book_id, update);
            log.info(book.book_count+ "copies of"+ update.book_name +"have been returned");

        }
        else{
            System.out.println("that book is not from this library");
            log.info("invalid book return: book nonexistent");
        }
    }

    public void borrow_book(Book book){
        if (Booklist.containsKey(book.book_id)){
            Book update = Booklist.get(book.book_id);
            update.book_count-=book.book_count;
            Booklist.put(book.book_id,update);
            log.debug(book.book_count+ "copies of"+ update.book_name +"have been borrowed");
        }
        else{
            System.out.println("this library does not have that book");
            log.debug("invalid book borrowing: book nonexistent");
        }
    }

    public void give_book(Book book){
        if (!Booklist.containsKey(book.book_id)){
            Booklist.put(book.book_id,book);
            log.info(book.book_count+ "copies of"+ book.book_name +"have been given");
        }
        else{
            System.out.println("this library has this book but we appreciate the new copy");
            Book update = Booklist.get(book.book_id);
            update.book_count+=book.book_count;
            Booklist.put(book.book_id,update);
            log.debug("attempt to give existent book, added as "+book.book_count+" copy(s)");
        }
    }
}
