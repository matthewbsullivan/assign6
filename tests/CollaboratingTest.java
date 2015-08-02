package tests;

import assign6.*;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by PaleToys on 8/2/2015.
 */
public class CollaboratingTest {

    //Set a new book, and new movie.
    Book testBook = new Book(1234, "War & Peace", "21455512", "Leo Tolstoy");
    Book testBook2 = new Book(12341234, "War & Peace 2", "21455512", "Leo Tolstoy");
    Movie testMovie = new Movie(123456,"This is a movie","987654321");
    Movie testMovie2 = new Movie(1234567,"This is a movie 2","987654321");


    //instantiate a MemberList and Collection
    MemberList memberListTest = new MemberList();
    Collection collectionTest = new Collection();

    //Instantiate a new member as student and one as staff
    Member studentMemberTest = new Student(222);
    Member facultyMemberTest = new Faculty(111);
    Member studentMemberTest2 = new Student(2222);
    Member facultyMemberTest2 = new Faculty(1111);


    //Add resources to the resources list

    /**
     * testCndStuBook = Test Calculate New due-date with Student and Book
     * </p>
     *  Tests to calculate new dude date for a student and book, and has an assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void TestUpdateNewDate() throws Exception{
        //////////////////////////////////////////////////////////////////////
        //Student and book test.
        ///////////////////////////////////////////////////////////////////////
        Calendar testDate = Calendar.getInstance();
        //Student and book test.
        //Add a book to our resource list,add a new due date to it, keep track of due date.
        collectionTest.addResource(testBook);
        testBook.setDueDate(testDate);
        Calendar testDateOld = testDate;

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl testControl = new CheckOutControl(memberListTest,
                collectionTest);

        //Student id is 222 and testBook is 1234
        testControl.checkout(222,1234);

        //Try to change due date.
        testBook.calculateNewDueDate(testDate, studentMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDate);

        //////////////////////////////////////////////////////////////////////
        //Student2 and movie test.
        ///////////////////////////////////////////////////////////////////////

        testDate = Calendar.getInstance();
        //Student and book test.
        //Add a book to our resource list,add a new due date to it, keep track of due date.
        collectionTest.addResource(testMovie);
        testMovie.setDueDate(testDate);
        testDateOld = testDate;

        testControl.checkout(222,123456);

        //Try to change due date.
        testMovie.calculateNewDueDate(testDate, studentMemberTest2);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDate);

        //////////////////////////////////////////////////////////////////////
        //Faculty and book2 test.
        ///////////////////////////////////////////////////////////////////////

        testDate = Calendar.getInstance();
        collectionTest.addResource(testBook2);
        testBook2.setDueDate(testDate);
        testDateOld = testDate;

        testControl.checkout(111,12341234);

        //Try to change due date.
        testBook2.calculateNewDueDate(testDate, facultyMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDate);

        //////////////////////////////////////////////////////////////////////
        //Faculty2 and Movie2 test.
        ///////////////////////////////////////////////////////////////////////

        testDate = Calendar.getInstance();
        collectionTest.addResource(testMovie2);
        testMovie2.setDueDate(testDate);
        testDateOld = testDate;

        testControl.checkout(1111,1234567);

        //Try to change due date.
        testMovie2.calculateNewDueDate(testDate, facultyMemberTest2);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDate);
    }


}
