package tests;

import assign6.*;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Unit tests for Resource
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class ResourceTest {

    /**
     * Test Methods for Problem #1
     */
    Calendar testDate = Calendar.getInstance();
    Book testBook = new Book(1234, "War & Peace", "21455512", "Leo Tolstoy");

    /**
     * Simulates a resource 10 days overdue. Correct late fine is $2.50
     * @throws Exception
     */
    @Test
     public void testPastDue() throws Exception {
        testBook.setDueDate(testDate);
        testDate.add(Calendar.DATE, 10);

        assertEquals("Late fine not assessed correctly", 2.5, testBook
                .calculateFine(testDate), .00);
    }

    /**
     * Simulates a resource due today. Correct late fine is 0.
     * @throws Exception
     */
    @Test
    public void testDueToday() throws Exception {
        Calendar cloneDate = (Calendar)testDate.clone();
        testBook.setDueDate(testDate);
        assertEquals("Resource turned in on due date should have no late fine",
                0, testBook.calculateFine(cloneDate), .00);
    }

    /**
     * Simulates a resource not due in 10 days. Correct late fine is 0.
     * @throws Exception
     */
    @Test
    public void testNotDueYet() throws Exception {
        testBook.setDueDate(testDate);
        testDate.add(Calendar.DATE, -10);
        assertEquals("Resource not yet due should have no late fine", 0,
                testBook.calculateFine(testDate), .00);
    }

    /**
     * Simulates a resource with no due date. Correct late fine is 0.
     * @throws Exception
     */
    @Test
    public void testNoDueDate() throws Exception {
        assertEquals("Resource with no due date should have no late fine", 0,
                testBook.calculateFine(testDate), .00);
    }

    /**
     * Test Methods for Problem #3
     */
    //Initialize Calendar
    Calendar testDateC = Calendar.getInstance();

    //Set a new movie.
    Resource testMovie = new Movie(123456,"This is a movie","987654321");



    //instantiate a MemberList and Collection
    MemberList memberListTest = new MemberList();
    Collection collectionTest = new Collection();

    //Instantiate a new member as student and one as staff
    Member studentMemberTest = new Student(222);
    Member facultyMemberTest = new Faculty(111);

    //Books Test-cases
    //Student
    /**
     * testCndStuBook = Test Calculate New due-date with Student and Book
     * </p>
     *  Tests to calculate new dude date for a student and book, and has an
     *  assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void testCndStuBook() throws Exception{
        //Add a book to our resource list,add a new due date to it, keep track
        // of due date.
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
     * testCndFacBook = Test Calculate New due-date with Faculty and Book
     * </p>
     *  Tests to calculate new dude date for a Faculty and book, and has an
     *  assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void testCndFacBook() throws Exception {
        //Add a book to our resource list,add a new due date to it, keep track
        // of due date.
        collectionTest.addResource(testBook);
        testBook.setDueDate(testDateC);
        Calendar testDateOld = testDateC;

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl testControl = new CheckOutControl(memberListTest,
                collectionTest);
        testControl.checkout(facultyMemberTest.getMemberID(),
                testBook.getResourceID());

        //Try to change due date.
        testBook.calculateNewDueDate(testDateC, studentMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDateC);
    }
    //Movies Test-cases
    /**
     * testCndStuBook = Test Calculate New due-date with Student and Movie
     * </p>
     *  Tests to calculate new dude date for a student and book, and has an
     *  assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void testCndStuMovie() throws Exception{
        //Add a book to our resource list,add a new due date to it, keep
        // track of due date.
        collectionTest.addResource(testMovie);
        testMovie.setDueDate(testDateC);
        Calendar testDateOld = testDateC;

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl testControl = new CheckOutControl(memberListTest,
                collectionTest);
        testControl.checkout(studentMemberTest.getMemberID(),
                testMovie.getResourceID());

        //Try to change due date.
        testMovie.calculateNewDueDate(testDateC, studentMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDateC);
    }
    //Faculty
    /**
     * testCndFacBook = Test Calculate New due-date with Faculty and Movie
     * </p>
     *  Tests to calculate new dude date for a Faculty and book, and has an
     *  assertion to make sure that the due date
     *  </p>
     *  has changed.
     */
    @Test
    public void testCndFacMovie() throws Exception {
        //Add a movie to our resource list,add a new due date to it, keep track
        // of due date.
        collectionTest.addResource(testMovie);
        testMovie.setDueDate(testDateC);
        Calendar testDateOld = testDateC;

        //Construct a new CheckOutControl using the MemberList and Collection
        CheckOutControl testControl = new CheckOutControl(memberListTest,
                collectionTest);
        testControl.checkout(facultyMemberTest.getMemberID(),
                testMovie.getResourceID());

        //Try to change due date.
        testMovie.calculateNewDueDate(testDateC, studentMemberTest);

        //Test to make sure that the due date has been changed
        assertEquals("The new date was not updated", testDateOld,testDateC);
    }
}