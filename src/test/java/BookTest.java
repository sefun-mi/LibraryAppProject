import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldCreateBook(){
        Book danBrown = new Book("001","deception_point",1);
        Assertions.assertFalse(danBrown==null);

    }

}