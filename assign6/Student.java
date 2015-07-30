package assign6;

import java.util.Calendar;

public class Student extends Member {

	public Student(int memberID) {
		super(memberID);
	}

	@Override
	public void calculateNewBookDueDate(Calendar startDate) {
		startDate.add(Calendar.DATE, 28);  //Books are checked out for 4 weeks
	}

}
