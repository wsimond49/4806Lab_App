package access;

import addressbook.BuddyInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("addressbook")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few BuddyInfos
            repository.save(new BuddyInfo("Jack Bauer", "a", "b", "c", "d"));
            repository.save(new BuddyInfo("Chloe O'Brian", "e", "f", "g", "h"));
            repository.save(new BuddyInfo("Kim Bauer", "i", "j", "k", "l"));
            repository.save(new BuddyInfo("David Palmer", "aa", "bb", "cc", "dd"));
            repository.save(new BuddyInfo("MichelleDessler", "ab", "bc", "cd", "de"));

            // fetch all BuddyInfos
            System.out.println("BuddyInfos found with findAll():");
            System.out.println("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                System.out.println(buddy.toString());
            }
            System.out.println();

            // fetch an individual BuddyInfo by ID
            BuddyInfo BuddyInfo = repository.findById(2L);
            System.out.println("BuddyInfo found with findById(2L):");
            System.out.println("--------------------------------");
            System.out.println(BuddyInfo.toString());
            System.out.println();

            // fetch BuddyInfos by last name
            System.out.println("BuddyInfo found with findByName('Jack Bauer'):");
            System.out.println("--------------------------------------------");
            repository.findByName("Jack Bauer").forEach(bauer -> System.out.println(bauer.toString()));
            System.out.println();
        };
    }
}