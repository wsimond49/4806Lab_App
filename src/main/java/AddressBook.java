import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public int getSize() {
        return this.buddies.size();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "buddies='" + this.buddies.toString() +
                "'}";
    }

    public static void main(String[] args) {
        BuddyInfo buddy1 = new BuddyInfo("Simon", "123 Main St.", "1/2/02", "Jeff Co.", "1234567890");
        BuddyInfo buddy2 = new BuddyInfo("Bob", "456 Front St.", "3/4/66", "Fresh Co.", "0987654321");
        BuddyInfo buddy3 = new BuddyInfo("Jill", "246 80 St.", "5/6/86", "My Co.", "1357924680");
        BuddyInfo buddy4 = new BuddyInfo("Harry", "135 Back St.", "7/8/99", "Generic Co.", "2468013579");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        addressBook.addBuddy(buddy3);
        addressBook.addBuddy(buddy4);
        System.out.println(addressBook);
    }
}
