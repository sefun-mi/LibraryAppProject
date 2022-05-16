import org.apache.log4j.*;
import java.util.*;

public class LibUser {
    String user_name;
    String user_ID;
    int level;

    static Logger log = Logger.getLogger(LibUser.class.getName());


    public LibUser(String user_name, String user_ID, int level){
        this.user_name = user_name;
        this.user_ID = user_ID;
        this.level = level;
        log.info("new user created:"+user_name);
    }





}
