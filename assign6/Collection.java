package assign6;

import java.util.ArrayList;

/**
 * Represents the collection of the Library.
 *
 * @author Jill Seaman
 *
 */
public class Collection  {
	
	private ArrayList<Resource> collection =
            new ArrayList<Resource>();        // list of resources
	
	/**
	 * Default constructor, creates an empty collection
	 */
	public Collection() {
	}
    
	/**
	 * Given a resource instance, adds it to the end of the collection
     * as long as its ID is not already used by another resource in the collection.
     * @param resource the item to add to the collection
	 */
	public boolean addResource(Resource resource) {
        
        //check for uniqueness of product
        int index = searchList(resource.getResourceID());
        
        // if  found, return false
        if (index!=-1) {
            return false;
        }
        
        else {
            collection.add(resource);
            return true;
        }
    }
    
    
    
    /**
     * removes a resource from the collection based on the given resourceID.
     * If no resource with that id is in the collection, returns false.
     * @param resourceID the id of the resource to be removed
     */
    public boolean removeResource(int resourceID) {
        
        // find the resourceID in the array
        int index = searchList(resourceID);
        
        // if found, remove it, else output message
        if (index == -1) {
            return false;
        } else {
            collection.remove(index);
            return true;
        }
    }
    
    /**
     * finds a resource in the collection based on the given resourceID.
     * If no resource with that id is in the collection, returns null.
     * @param resourceID the id of the resource to be found
     */
    public Resource findResource(int resourceID) {
        // find the resourceID in the array
        int index = searchList(resourceID);
        if (index == -1)
            return null;
        return collection.get(index);
    }
    
    /**
     * Uses linear search to find a resource in the list according to its 
     * resource ID.
     * @param value the resource ID to search for
     * @return the index of the resource in the collection, or -1 if not found
     */
    private int searchList ( int value) {
        // iterate over the list until found
        for (int i=0; i<collection.size(); i++) {
            // check if the current resource is the one we're looking for
            if (collection.get(i).getResourceID() == value)
                return i;
        }
        return -1;
    }
}