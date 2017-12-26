package maman14a;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericSet<E> {
    private ArrayList<E> set;

    /**
     * Empty constructor
     */
    public GenericSet() {
        set = new ArrayList<>();
    }

    /**
     * Constructor
     * @param set Set
     */
    public GenericSet(ArrayList<E> set) {
        this.set = set;
    }
    
    /**
     * Combine sets with each other
     * @param set Set to be combined with
     */
    public void union(GenericSet<E> set) {
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            insert((E) iterator.next()); // insert items not currently in the set
        }
    }
    
    /**
     * Intersect sets with each other
     * @param set Set to intersect with
     */
    public void intersect(GenericSet<E> set) {
        ArrayList<E> tempSet = new ArrayList<>();
        Iterator iterator = set.iterator();
        
        // Iterate over the set
        while(iterator.hasNext()) {
            E item = (E) iterator.next();
            // Add members of both sets
            if(isMember(item)) { 
                tempSet.add(item);
            }
        }
        
        this.set = tempSet;
    }
    
    /**
     * Checks if the given group is a subset of the current group
     * @param set Subset
     * @return true if the given group is a subset, false otherwise
     */
    public boolean isSubset(GenericSet<E> set) {

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            // If one item is not a member of the set, return false
            if(!isMember((E) iterator.next())) { 
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Checks if the given item is a member of the group
     * @param item Member
     * @return true if the given item is a member, false otherwise
     */
    public boolean isMember(E item) {
        return this.set.contains(item);
    }
    
    /**
     * Insert an item to the group. If the item is a member of the group,
     * this method will do nothing.
     * @param item Item to insert
     * @return true on successful insertion, false otherwise
     */
    public boolean insert(E item) {
        boolean result = false;
        if(!isMember(item)) {
            this.set.add(item);
            result = true;
        }
        
        return result;
    }
    
    /**
     * Delete an item from the group. If the item is not a member of the group,
     * this method will do nothing.
     * @param item Item to delete
     * @return true on successful deletion, false otherwise
     */
    public boolean delete(E item) {
        boolean result = false;
        if(isMember(item)) {
            this.set.remove(item);
            result = true;
        }
        
        return result;
    }
    
    /**
     * Get the set iterator
     * @return iterator of the set
     */
    public Iterator iterator() {
        return this.set.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        
        // Iterate over the set and append to the result
        for(E item : this.set) {
            builder.append(item).append(",");
        }
        builder.append("}");
        
        return builder.toString();
    }
}
