package assign6;

import java.util.Calendar;


/**
 * A book in the collection
 * @author Jill Seaman
 */
public class Book extends Resource {
	
	private String isbn;       // international standard book number
	private String author;     // author(s) of the book

	/**
	 * construct book from parameters
	 * @param resourceID
	 * @param title
	 * @param isbn
	 * @param author
	 */
	public Book(int resourceID, String title, String isbn, String author) {
		super(resourceID, title);
		this.isbn = isbn;
		this.author = author;
	}

	@Override
	public void calculateNewDueDate(Calendar startDate, Member member) {
		member.calculateNewBookDueDate(startDate); //uses proper value for the member type
		setDueDate(startDate);            //saves (a copy of) the new due date
		
	}
}
