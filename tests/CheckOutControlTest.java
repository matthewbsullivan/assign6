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

    /**
     * We are testing the following cases for checkout():
     * 1. An invalid member tries to checkout an invalid resource: unsuccessful
     * 2. A valid member tries to checkout an invalid resource: unsuccessful
     *  2a. Resource is not in Collection.
     *  2b. Resource is already checked out.
     * 3. An invalid member tries to checkout a valid resource: unsuccessful
     * 4. A valid member tries to checkout a valid resource: successful
     *
     * Additionally, we are checking that when checkout is successful, a
     * resource's status is changed to CHECKED_OUT and the resource is added
     * to the member.
     *
     * Test cases are out of order to minimize repetitious code.
     *
     * @throws Exception
     */
    @Test
    public void testCheckout() throws Exception {
        //arbitrary member and resource instants to use as test data
        Member memberTest = new Student(222);
        Movie resourceTest = new Movie(134, "Haywire", "35610");

        //instantiate a MemberList and Collection
        MemberList memberListTest = new MemberList();
        Collection collectionTest = new Collection();

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl test = new CheckOutControl(memberListTest,
                collectionTest);

        //Case 1.
        //Simulate an invalid member attempting to check out an invalid
        // resource. Will equal something other than null in the
        // event of a failure.
        assertEquals("Invalid member can't checkout an invalid resource",null,
                test.checkout(memberTest.getMemberID(),
                resourceTest.getResourceID()));

        //now add our test Member to our MemberList
        memberListTest.addMember(memberTest);

        //Case 2b.
        //Simulate a valid member attempting to check out a resource not in
        // Collection. Will equal something other than null in the
        // event of a failure.
        assertEquals("Can't check out a resource not in Collection", null, test
                .checkout
                (memberTest.getMemberID(), resourceTest.getResourceID()));

        //now add our test Resource to our Collection
        collectionTest.addResource(resourceTest);

        //Case 4.
        //Simulate a valid member attempting to check out a valid resource.
        // Will equal null in the event of a failure.
        assertNotEquals("Successful checkout should not return null", null, test
                .checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));
        assertEquals("Resource status should equal zero", 0, resourceTest
                .getStatus());
        assertEquals("Resource ID should be added to Member", resourceTest
                .getResourceID(), memberTest.findResource(resourceTest
                        .getResourceID()));


        //Change resource to CHECKED_OUT
        resourceTest.setStatus(Resource.CHECKED_OUT);

        //Case 2a.
        //Simulate a valid member attempting to check out a checked out
        // resource. Will equal something other than null in the
        // event of a failure.
        assertEquals("Can't check out a resource that has already been " +
                "checked out", null, test.checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));

        //put resource back on the shelf
        resourceTest.setStatus(Resource.ON_THE_SHELF);

        //now remove our test member from our MemberList
        memberListTest.removeMember(memberTest.getMemberID());

        //Case 3.
        //Simulate an invalid member attempting to check out a valid
        // resource. Will equal something other than null in the
        // event of a failure.
        assertEquals("Member not in MemberList can't checkout a resource",
                null, test.checkout(memberTest.getMemberID(),
                        resourceTest.getResourceID()));
    }
}