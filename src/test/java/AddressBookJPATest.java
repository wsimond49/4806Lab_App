import addressbook.BuddyInfo;
import addressbook.AddressBook;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;


public class AddressBookJPATest {
    @Test
    public void JPATest() {
        BuddyInfo buddy1 = new BuddyInfo("Simon", "123 Main St.", "1/2/02", "Jeff Co.", "1234567890");
        BuddyInfo buddy2 = new BuddyInfo("Bob", "456 Side St.", "1/2/12", "Jo Co.", "0987654321");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-address-book");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        AddressBook book = new AddressBook();
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);

        em.persist(book);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (AddressBook b : results) {
            System.out.println(b.toString() + " (id=" + b.getId() + ")");
        }

        // Closing connection
        em.close();
        emf.close();
    }
}
