package assign6;

import java.util.Calendar;

public class CheckOutControl {
	
	private MemberList memberList;
	private Collection collection;
	
	public CheckOutControl(MemberList memberList, Collection collection) {
		this.memberList = memberList;
		this.collection = collection;
	}

    /**
     * Given a member ID and a resource ID, calculates the new due date and
     * assigns the resource to the member's list of checked out items, and
     * sets its status to CHECKED OUT and its due date to the new due date. 
     * The resource must not already be checked out.
     * NOTE: this version implements the first sequence diagram in the A4
     *  solution (not the best one).
     * @param memberID id of the member who wants to check out the resource
     * @param resourceID id of the resource to be checked out.
     * @return the due date of the item.
     */
	public Calendar checkout(int memberID, int resourceID) {
		
		Member member = memberList.findMember(memberID);
		Resource resource = collection.findResource(resourceID);
		
		if (member == null || resource == null) {
			return null;
		}
		
		if (resource.getStatus()==Resource.CHECKED_OUT) {
			return null;
		}
		
		Calendar startDate = Calendar.getInstance();  // use today's date
		resource.calculateNewDueDate(startDate, member);
		resource.setStatus(Resource.CHECKED_OUT);
		member.addResource(resource);
		return startDate;
		
	}

}
