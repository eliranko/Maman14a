package maman14a;

import java.util.Random;
import java.util.Scanner;

public class Maman14a {

    private static final int SET_SIZE = 10;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int USER_CUSTOM_SET_SIZE = 2;
    private static final int DEFAULT_USER_INPUT_VALUE = 50;
    private static final Random RAND = new Random();
    public static void main(String[] args) {
        // Create sets
        GenericSet<Integer> set1 = new GenericSet<>();
        GenericSet<Integer> set2 = new GenericSet<>();
        GenericSet<Integer> set3 = new GenericSet<>();
        set1.insert(1);
        System.out.println(set1.isMember(1));
        // Fill sets
        fillSetWithRandomValues(set1);
        fillSetWithRandomValues(set2);
        fillSetWithRandomValues(set3);
        
        // Print the sets
        System.out.println("First set = " + set1);
        System.out.println("Second set = " + set2);
        System.out.println("Third set = " + set3);
        
        // Union of set1 and set2
        set1.union(set2);
        System.out.println("Union of the first and second sets, The first set now equals" + 
                set1);
        
        // Intersect set1 with set3
        set1.intersect(set3);
        System.out.println("Intersection of the first and third sets, The first set now equals" + 
                set1);
        
        // Get a set from the user
        GenericSet<Integer> userSet = getSetFromUser();
        String subsetPrint = isSubset(userSet, set1, set2, set3) ? 
                " is a subset!"
                : 
                " is NOT a subset!";
        System.out.println("The given user set " + userSet + subsetPrint);
        
        // Receive value from user
        int userValue = receiveValueFromUser();
        String isMemberPrint = set1.isMember(userValue) ? 
                " is a member of the first set"
                : " is not a member of the first set";
        System.out.println("The given value: " + userValue + isMemberPrint);
        
        set2.insert(userValue);
        System.out.println("After adding " + userValue +
                " to the second group, the new group is: " + set2);
        
        set3.delete(userValue);
        System.out.println("After deleting " + userValue +
                " from the third group, the new group is: " + set3);
    }
    
    private static void fillSetWithRandomValues(GenericSet<Integer> set) {
        boolean insertionResult;
        
        for(int i = 0; i < SET_SIZE; i++) {
            do {
                insertionResult = set.insert(getRandomValue());
            } while(!insertionResult); // Keep trying to insert, if the elements is a member
        }
    }
    
    private static int getRandomValue() {
        return RAND.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) 
                + MIN_RANDOM_VALUE; // Get random int between MIN-MAX (including)
    }
    
    private static GenericSet<Integer> getSetFromUser() {
        // Receive numbers from user
        System.out.println("Please enter two numbers to create a custom set:");
        int number1 = receiveValueFromUser();
        int number2 = receiveValueFromUser();
        
        // Create set
        GenericSet<Integer> set = new GenericSet<>();
        set.insert(number1);
        set.insert(number2);
        
        return set;
    }
    
    private static boolean isSubset(GenericSet<Integer> set, GenericSet<Integer>... sets) {
        // Iterate over the sets and check if one is a superset of the given set
        for(GenericSet<Integer> someSet : sets) {
            if(someSet.isSubset(set)) {
                return true;
            }
        }
        
        // No supersets here...
        return false;
    }
    
    private static int receiveValueFromUser() {
        System.out.println("Please enter a number:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        
        try {
            return Integer.parseInt(number);
        }
        catch(NumberFormatException e) {
            return DEFAULT_USER_INPUT_VALUE;
        }
    }
}
