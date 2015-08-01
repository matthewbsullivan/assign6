package tests;

import assign6.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit Tests for CheckOutControl
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class CheckOutControlTest {

    //arbitrary member and resource instants to use as test data
    Member memberTest = new Student(222);
    Movie resourceTest = new Movie(134, "Haywire", "35610");

    //instantiate a MemberList and Collection
    MemberList memberListTest = new MemberList();
    Collection collectionTest = new Collection();

    //Construct a new CheckOutControl using the MemberList and Collection
    CheckOutControl testControl = new CheckOutControl(memberListTest,
            collectionTest);

    /**
     * Simulate an invalid member attempting to check out an invalid
     * resource. Will equal something other than null in the
     * event of a failure.
     * @throws Exception
     */
    @Test
    public void testInvalidMemberInvalidResource() throws Exception {

        assertNull("Invalid member can't checkout an invalid resource",
                testControl.checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));
    }

    /**
     * Simulate a valid member attempting to check out a resource not in
     * Collection. Will equal something other than null in the
     * event of a failure.
     * @throws Exception
     */
    @Test
    public void testCheckoutNonExistingResource() throws Exception {

        memberListTest.addMember(memberTest);

        assertNull("Can't check out a resource not in Collection",
                testControl.checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));
    }

    /**
     *Simulate a valid member attempting to check out a valid resource.
     */
    @Test
    public void testValidCheckout() {

        memberListTest.addMember(memberTest);
        collectionTest.addResource(resourceTest);

        assertNotNull("Successful checkout should not return null",
                testControl.checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));
    }

    /**
     * Simulate a checkout and test that the resource's status has been
     * changed to 0 (Off the shelf)
     */
    @Test
    public void testCheckoutStatus() {

        collectionTest.addResource(resourceTest);
        memberListTest.addMember(memberTest);
        testControl.checkout(memberTest.getMemberID(),
                resourceTest.getResourceID());

        assertEquals("Resource status should equal zero", 0, resourceTest
                .getStatus());
    }

    /**
     * Simulate a checkout and ensure that the resource has been added to the
     * member.
     */
    @Test
    public void testResourceIDAdded() {

        collectionTest.addResource(resourceTest);
        memberListTest.addMember(memberTest);
        testControl.checkout(memberTest.getMemberID(),
                resourceTest.getResourceID());

        assertEquals("Resource ID should be added to Member", resourceTest
                .getResourceID(), memberTest.findResource(resourceTest
                .getResourceID()).getResourceID());
    }

    /**
     * Simulate a valid member attempting to check out a checked-out resource.
     */
    @Test
    public void testCheckoutAlreadyCheckedOutResource() {

        collectionTest.addResource(resourceTest);
        memberListTest.addMember(memberTest);
        resourceTest.setStatus(Resource.CHECKED_OUT);

        assertNull("Can't check out a resource that has already been " +
                "checked out", testControl.checkout(memberTest.getMemberID(),
                resourceTest.getResourceID()));
    }

    /**
     * Simulate an invalid member attempting to checkout a valid resource.
     */
    @Test
    public void testInvalidMemberCheckout() {

        collectionTest.addResource(resourceTest);

        assertNull("Member not in MemberList can't checkout a resource",
                testControl.checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));
    }
}