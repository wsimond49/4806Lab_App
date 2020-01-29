package access.addressbook;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public int getSize() {
        return this.buddies.size();
    }

    @Override
    public String toString() {
        return "access.addressbook.AddressBook{" +
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
