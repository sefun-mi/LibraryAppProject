import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {


    @Test
    public void bookadd(){
        Library testlib = new Library();
        Book temp = new Book("0000","temp_book",3);
        testlib.give_book(temp);
        Assertions.assertEquals(1,testlib.Booklist.size());
    }

}