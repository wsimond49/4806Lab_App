import access.addressbook.AddressBook;
import access.addressbook.BuddyInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressBookTest {
    @Test
    public void emptyAddressBookTest() {
        AddressBook book = new AddressBook();

        assertEquals(0, book.getSize());
    }

    @Test
    public void oneBuddyAddressBookTest() {
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Simon", "123 Main St.", "1/2/02", "Jeff Co.", "1234567890");
        book.addBuddy(buddy);

        assertEquals(1, book.getSize());
    }

    @Test
    public void toStringAddressBookTest() {
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Simon", "123 Main St.", "1/2/02", "Jeff Co.", "1234567890");
        book.addBuddy(buddy);

        assertEquals("access.addressbook.AddressBook{buddies='[access.addressbook.BuddyInfo{name='Simon', address='123 Main St.', birthday='1/2/02', company='Jeff Co.', phoneNumber='1234567890'}]'}", book.toString());
    }

}