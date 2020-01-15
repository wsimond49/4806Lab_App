package addressbook;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String birthday;
    private String company;
    private String phoneNumber;

    public BuddyInfo() {
        this.name = null;
        this.address = null;
        this.birthday = null;
        this.company = null;
        this.phoneNumber = null;
    }

    public BuddyInfo(String name, String address, String birthday,
                     String company, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.company = company;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "addressbook.BuddyInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", company='" + company + '\'' +
                ", phoneNumber='" + phoneNumber +
                "'}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
