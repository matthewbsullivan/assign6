package tests;

import assign6.Book;
import assign6.Member;
import assign6.Resource;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Unit tests for Resource
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class ResourceTest {

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

    @Test
    public void testCalculateNewDueDate() throws Exception {

    }
}