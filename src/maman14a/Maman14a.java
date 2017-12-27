package maman14a;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Maman14a {

    private static final int SET_SIZE = 10;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int USER_CUSTOM_SET_SIZE = 2;
    private static final int DEFAULT_USER_INPUT_VALUE = 50;
    private static final int PERSON_SET_SIZE = 5;
    private static final Random RAND = new Random();
    
    // Define the sets
    private static final GenericSet<Integer> SET1 = new GenericSet<>();
    private static final GenericSet<Integer> SET2 = new GenericSet<>();
    private static final GenericSet<Integer> SET3 = new GenericSet<>();
    private static final GenericSet<Person> PERSON_SET = new GenericSet<>();
    
    public static void main(String[] args) {
        fillSets();
        printSets();
        unionSets(SET1, SET2);
        intersectSets(SET1, SET3);
        receiveSubsetFromUser();
        receiveValueFromUser();
        printMinimumPerson(PERSON_SET);
    }
      
    private static void printMinimumPerson(GenericSet<Person> set) {
        System.out.println("The youngest person in the persons set is: " + 
                Comparation.getMinItem(set));
    }
    
    private static void receiveValueFromUser() {
        int userValue = receiveIntegerFromInput();
        String isMemberPrint = SET1.isMember(userValue) ? 
                " is a member of the first set"
                : " is not a member of the first set";
        System.out.println("The given value: " + userValue + isMemberPrint);
        
        SET2.insert(userValue);
        System.out.println("After adding " + userValue +
                " to the second group, the new group is: " + SET2);
        
        SET3.delete(userValue);
        System.out.println("After deleting " + userValue +
                " from the third group, the new group is: " + SET3);
    }
    
    private static void receiveSubsetFromUser() {
        GenericSet<Integer> userSet = receiveSetFromUser();
        String subsetPrint = isSubset(userSet, SET1, SET2, SET3) ? 
                " is a subset!"
                : 
                " is NOT a subset!";
        System.out.println("The given user set " + userSet + subsetPrint);
    }
    
    private static void unionSets(GenericSet<Integer> set1, GenericSet<Integer> set2) {
        System.out.print(set1 + " union " + set2 + " = ");
        set1.union(set2);
        System.out.println(set1);
    }
    
    private static void intersectSets(GenericSet<Integer> set1, GenericSet<Integer> set2) {
        System.out.print(set1 + " intersect " + set2 + " = ");
        set1.intersect(set2);
        System.out.println(set1);
    }
    
    private static void printSets() {
        System.out.println("First set = " + SET1);
        System.out.println("Second set = " + SET2);
        System.out.println("Third set = " + SET3);
        System.out.println("Persons set = " + PERSON_SET);
    }
    
    private static void fillSets() {
        // Fill integer sets
        fillSetWithRandomValues(SET1);
        fillSetWithRandomValues(SET2);
        fillSetWithRandomValues(SET3);
        
        // Fill persons set
        int id = 1;
        int age = 1;
        String name = "Person";
        for(int i = 0; i < PERSON_SET_SIZE; i++) {
            PERSON_SET.insert(new Person(id + i, name + i, age + i));
        }
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
    
    private static GenericSet<Integer> receiveSetFromUser() {
        System.out.println("Please create a custom set:");
        ArrayList<Integer> numbers = new ArrayList<>(USER_CUSTOM_SET_SIZE);
        
        // Receive numbers from user
        for(int i = 0; i < USER_CUSTOM_SET_SIZE; i++) {
            numbers.add(receiveIntegerFromInput());
        }
        
        return new GenericSet<Integer>(numbers);
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
    
    private static int receiveIntegerFromInput() {
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
