import addressbook.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    @Test
    public void emptyBuddyTest() {
        BuddyInfo buddy = new BuddyInfo();

        assertNull(buddy.getName());
        assertNull(buddy.getAddress());
        assertNull(buddy.getBirthday());
        assertNull(buddy.getCompany());
        assertNull(buddy.getPhoneNumber());
    }

    @Test
    public void idBuddyTest() {
        BuddyInfo buddy = new BuddyInfo("Simon", null, null, null, null);

        assertEquals("Simon", buddy.getName());
    }

    @Test
    public void nameBuddyTest() {
        BuddyInfo buddy = new BuddyInfo("Simon", null, null, null, null);

        assertEquals("Simon", buddy.getName());
    }

    @Test
    public void addressBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, "123 Main St.", null, null, null);

        assertEquals("123 Main St.", buddy.getAddress());
    }

    @Test
    public void birthdayBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, null, "1/2/34", null, null);

        assertEquals("1/2/34", buddy.getBirthday());
    }

    @Test
    public void companyBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, null, null, "Jo Co.", null);

        assertEquals("Jo Co.", buddy.getCompany());
    }

    @Test
    public void phoneNumberBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, null, null, null, "1234567890");

        assertEquals("1234567890", buddy.getPhoneNumber());
    }

    @Test
    public void allAttributeBuddyTest() {
        BuddyInfo buddy = new BuddyInfo("Simon", "123 Main St.", "1/2/34", "Jo Co.", "1234567890");

        assertEquals("Simon", buddy.getName());
        assertEquals("123 Main St.", buddy.getAddress());
        assertEquals("1/2/34", buddy.getBirthday());
        assertEquals("Jo Co.", buddy.getCompany());
        assertEquals("1234567890", buddy.getPhoneNumber());
    }

    @Test
    public void toStringBuddyTest() {
        BuddyInfo buddy = new BuddyInfo("Simon", "123 Main St.", "1/2/34", "Jo Co.", "1234567890");

        assertEquals("addressbook.BuddyInfo{name='Simon', address='123 Main St.', birthday='1/2/34', company='Jo Co.', phoneNumber='1234567890'}", buddy.toString());
    }
}