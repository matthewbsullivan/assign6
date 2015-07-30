package assign6;

import java.util.Calendar;

public class Faculty extends Member {

	public Faculty(int memberID) {
		super(memberID);
	}

	@Override
	public void calculateNewBookDueDate(Calendar startDate) {
		startDate.add(Calendar.MONTH, 3);  //Books are checked out for 3 Months

	}

}
