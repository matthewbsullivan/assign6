package tests;

import assign6.*;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by PaleToys on 8/2/2015.
 */
public class CollaboratingTest {
    //Initialize Calendar
    Calendar testDateC = Calendar.getInstance();

    //Set a new book, and new movie.
    Book testBook = new Book(1234, "War & Peace", "21455512", "Leo Tolstoy");
    Resource testMovie = new Movie(123456,"This is a resource","987654321");



    //instantiate a MemberList and Collection
    MemberList memberListTest = new MemberList();
    Collection collectionTest = new Collection();

    //Instantiate a new member as student and one as staff
    Member studentMemberTest = new Student(222);
    Member facultyMemberTest = new Faculty(111);

    Calendar testDate = Calendar.getInstance();
    //Add resources to the resources list


    //Books Test-cases
        //Student
    /**
     * testCndStuBook = Test Calculate New due-date with Student and Book
     * </p>
     *  Tests to calculate new dude date for a student and book, and has an assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void testCndStuBook() throws Exception{
        //Add a book to our resource list,add a new due date to it, keep track of due date.
        collectionTest.addResource(testBook);
        testBook.setDueDate(testDateC);
        Calendar testDateOld = testDateC;

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl testControl = new CheckOutControl(memberListTest,
                collectionTest);

        //Student id is 222 and testBook is 1234
        testControl.checkout(222,1234);

        //Try to change due date.
        testBook.calculateNewDueDate(testDateC, studentMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDateC);
    }
        //Faculty
    /**
     * testCndFacBook = Test Calculate New due-date with Student and Book
     * </p>
     *  Tests to calculate new dude date for a student and book, and has an assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void testCndFacBook() throws Exception {
        //Add a book to our resource list,add a new due date to it, keep track of due date.
        collectionTest.addResource(testBook);
        testBook.setDueDate(testDateC);
        Calendar testDateOld = testDateC;

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl testControl = new CheckOutControl(memberListTest,
                collectionTest);

        //Faculty id is 222 and testBook is 1234
        testControl.checkout(111, 1234);

        //Try to change due date.
        testBook.calculateNewDueDate(testDateC, studentMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDateC);
    }
    //Movies Test-cases

}
