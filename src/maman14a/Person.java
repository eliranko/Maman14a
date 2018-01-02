package maman14a;

public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private int age;

    /**
     * Constructor
     * @param id person's id
     * @param name person's name
     * @param age  person's age
     */
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Empty constructor
     */
    public Person() {
        this.id = 0;
        this.name = "";
        this.age = 0;
    }
    
    /**
     * Get id
     * @return integer id
     */
    public int getId() {
        return id;
    }

    /**
     * Set person's id
     * @param id person's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get person's name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set person's name
     * @param name person's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get person's age
     * @return integer age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set person's age
     * @param age integer age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person other = (Person) obj;
        return this.age == other.age;
    }
    
    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }
    
}
