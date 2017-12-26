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
    public void union(ArrayList<E> set) {
        for(E item : set) {
            insert(item); // insert items not currently in the set
        }
    }
    
    /**
     * Intersect sets with each other
     * @param set Set to intersect with
     */
    public void intersect(ArrayList<E> set) {
        ArrayList<E> tempSet = new ArrayList<>();
        for(E item : set) {
            if(isMember(item)) { // Add members of both sets
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
    public boolean isSubset(ArrayList<E> set) {
        for(E item : set) {
            if(!isMember(item)) { // If one item is not a member of the set, return false
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
     */
    public void insert(E item) {
        if(!isMember(item)) {
            this.set.add(item);
        }
    }
    
    /**
     * Delete an item from the group. If the item is not a member of the group,
     * this method will do nothing.
     * @param item Item to delete
     */
    public void delete(E item) {
        if(isMember(item)) {
            this.set.remove(item);
        }
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
        builder.append("GenericSet{").append("set=");
        
        // Iterate over the set and append to the result
        for(E item : this.set) {
            builder.append("\t").append(item);
        }
        builder.append("}");
        
        return builder.toString();
    }
}
