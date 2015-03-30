import priorityQueue.PriorityQueue;


/**
 * Created by ricardo on 30/03/2015.
 */
public class Person implements Comparable<Person> {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  Person) {
            Person p = (Person) obj;
            return p.name.equals(name);
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    public static void main(String[] args) {
        PriorityQueue<Person> persons = new PriorityQueue<>();
        persons.add(new Person("ze"));
        persons.add(new Person("maria"));
        persons.add(new Person("joaquim"));
        persons.add(new Person("palerma"));
        persons.add(new Person("ana"));
        persons.add(new Person("gustavo"));
        persons.add(new Person("filipe"));

        System.out.println(persons.remove(new Person("joaquim")));
        while (persons.size() > 0) {
            System.out.println(persons.remove());
        }
    }
}
