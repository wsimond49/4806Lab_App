package access;

import access.addressbook.AddressBook;
import access.addressbook.BuddyInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            BuddyInfo info1 = new BuddyInfo("Jack Bauer", "a", "b", "c", "d");
            BuddyInfo info2 = new BuddyInfo("Chloe O'Brian", "e", "f", "g", "h");
            BuddyInfo info3 = new BuddyInfo("Kim Bauer", "i", "j", "k", "l");
            BuddyInfo info4 = new BuddyInfo("David Palmer", "aa", "bb", "cc", "dd");
            BuddyInfo info5 = new BuddyInfo("Michelle Dessler", "ab", "bc", "cd", "de");
            AddressBook book = new AddressBook();
            book.setBuddies(new ArrayList<BuddyInfo>(Arrays.asList(info1, info2, info3, info4, info5)));
            repository.save(book);
        };
    }

}