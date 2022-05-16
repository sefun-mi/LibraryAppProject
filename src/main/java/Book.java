import org.apache.log4j.*;
public class Book {
    String book_id;
    String book_name;
    int book_count;

    static Logger log = Logger.getLogger(Book.class.getName());

    public Book(String book_id, String book_name, int book_count){
        this.book_count = book_count;
        this.book_name = book_name;
        this.book_id = book_id;
        log.debug("Book"+book_id+"created");
    }

    public void verifyBook(){
        System.out.println("Book name is"+ this.book_name + "Book ID is"+ this.book_id+"Number of copies is"+this.book_count);
    }
}
