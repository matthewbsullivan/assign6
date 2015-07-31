package tests;

import assign6.Member;
import assign6.Resource;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 *
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class ResourceTest {

    Resource tester = new Resource(23, "Moby Dick") {
        @Override
        public void calculateNewDueDate(Calendar startDate, Member member) {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DATE,10);
        }
    };

    @Test
    public void testCalculateFine() throws Exception {



        assertEquals();
    }

    @Test
    public void testCalculateNewDueDate() throws Exception {

    }
}