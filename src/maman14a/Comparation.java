package maman14a;

import java.util.Iterator;

public class Comparation {
    /**
     * Return the minimum item in the set
     * @param <E> Item of the set
     * @param set Set of items
     * @return null if the set is null \ no items are present in the set, 
     * and the minimum item in the set otherwise
     */
    public static <E extends Comparable<E>> E getMinItem(GenericSet<E> set) {
        if(set == null) return null;
        Iterator iterator = set.iterator();
        if(!iterator.hasNext()) return null; // No items in the set
        
        E minItem = (E) iterator.next();
        // Iterate the set
        while(iterator.hasNext()) {
            E currentItem = (E) iterator.next();
            if(currentItem.compareTo(minItem) < 0) minItem = currentItem;
        }
        
        return minItem;
    }
}
