package tests;

import assign6.Book;
import assign6.Collection;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test methods for Collection
 * @author Matt Sullivan
 * @author Luis Rocha
 */
public class CollectionTest {

    /**
     * Test Methods for Problem #2
     */
    Book testBook1 = new Book(1234, "Moby-Dick", "9780520045484", "Herman" +
            " " + "Melville");

    Collection testCollection = new Collection();

    /**
     * Causes an error if a duplicate resource can be added to a Collection
     * @throws Exception
     */
    @Test
    public void testAddDuplicateResource() throws Exception {

        Book testBook2 = testBook1;

        testCollection.addResource(testBook1);

        assertFalse("Cannot add a duplicate resource", testCollection
                .addResource(testBook2));
    }

    /**
     * Causes an error if a unique add resource attempt fails
     * @throws Exception
     */
    @Test
    public void testAddUniqueResource() throws Exception {

        testCollection.addResource(testBook1);

        assertEquals("Attempt to add unique resource failed", testBook1,
                testCollection.findResource(testBook1.getResourceID()));
    }
}