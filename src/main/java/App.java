import org.apache.log4j.*;
import java.util.*;

public class App {

    static Logger log = Logger.getLogger(App.class.getName());

    static Library lib = new Library();

    static Comparator<LibUser> comparator = new Mycomparator();
    static PriorityQueue<LibUser> sortQueue = new PriorityQueue<LibUser>(10,comparator);


    public static void executer(int action_code, Book book, LibUser user_){
        switch(action_code){
            case 1:
                lib.return_book(book);
                log.info("book return occuring");
            case 2:
                lib.borrow_book(book);
                log.info("book borrow occuring");
            case 3:
                lib.give_book(book);
                log.info("book being given");
        }

    }




    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("please type in your name and click enter");
        String name = sc.nextLine();
        System.out.println("now type in your Library ID and click enter");
        String id = sc.nextLine();
        System.out.println("finally type in your role in lowercase and click enter");
        System.out.println("NB: please type in your role as either 'senior_student','junior_student' or 'teacher'");
        String role = sc.nextLine();

        int user_level = 4;

        if(role.equals("junior_student")){
            user_level = 3;
        }
        else if(role.equals("senior_student")){
            user_level = 2;
        }
        else if(role.equals("teacher")){
            user_level = 1;
        }
        else{
            System.out.println("invalid role entry");
        }
        LibUser user = new LibUser(name,id,user_level);
        sortQueue.add(user);

        System.out.println("____________________________________________");
        System.out.println("Welcome "+user.user_name);
        System.out.println("please enter the name of the book you're contacting us about");
        String bookName = sc.nextLine();
        System.out.println("now enter the Book ID ...this can be found under the barcode at the back");
        String bookID = sc.nextLine();
        System.out.println("now please enter how many copies you want to borrow/return/donate");
        int volume_int = sc.nextInt();
        Book new_book = new Book(bookID,bookName,volume_int);
        new_book.verifyBook();

        System.out.println("____________________________________________");
        System.out.println("All set");
        System.out.println("what operation do you wish to perform");
        System.out.println("type 1 and click enter to return book");
        System.out.println("type 2 and click enter to borrow book");
        System.out.println("type 2 and click enter to donate book");
        int action = sc.nextInt();
        System.out.println("____________________________________________");
        System.out.println("Please hold on while we attend previous requests,you will be attended to shortly, thank you.");

        executer(action,new_book,sortQueue.poll());
    }
}
class Mycomparator implements Comparator<LibUser>{
    @Override
    public int compare(LibUser a,LibUser b){
        if(a.level>b.level){
            return 1;
        }
        else if(b.level>a.level){
            return -1;
        }
        return 0;
    }
}