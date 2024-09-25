package ait.citizens.dao;

import ait.citizens.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class CitizensImpl implements Citizens {
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;

    public CitizensImpl() {
        this.idList = new ArrayList<>();
        this.lastNameList = new ArrayList<>();
        this.ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        for (Person citizen : citizens) {
            add(citizen);
        }
    }

    @Override
    //  Complexity: O(1) by adding and O(n log n) by sorting
    public boolean add(Person person) {
        if (person == null || idList.contains(person) || lastNameList.contains(person) || ageList.contains(person)) {
            return false;
        }
        idList.add(person);
        idList.sort(Person::compareTo);
        lastNameList.add(person);
        lastNameList.sort(lastNameComparator);
        ageList.add(person);
        ageList.sort(ageComparator);
        return true;
    }

    @Override
    //Complexity O(n)
    public boolean remove(int id) {
        Person person = find(id);
        if (person == null) {
            return false;
        }
        idList.remove(person);
        lastNameList.remove(person);
        ageList.remove(person);
        return true;
    }

    @Override
    //Complexity O(n)
    public Person find(int id) {
        for (Person person : idList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    //Complexity O(n)
    public Iterable<Person> find(int minAge, int maxAge) {
        return findByPredicate(ageList, person -> person.getAge() >= minAge && person.getAge() <= maxAge);
    }

    private Iterable<Person> findByPredicate(List<Person> list, Predicate<Person> predicate) {
        List<Person> found = new ArrayList<>();
        for (Person person : list) {
            if (predicate.test(person)) {
                found.add(person);
            }
        }
        return found;
    }

    @Override
    //Complexity O(n)
    public Iterable<Person> find(String lastName) {
        return findByPredicate(lastNameList, person -> person.getLastName().equals(lastName));
    }

    @Override
    //Complexity O(n)
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    @Override
    //Complexity O(n)
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    @Override
    //Complexity O(n)
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;
    }

    @Override
    //Complexity O(1)
    public int size() {
        return idList.size();
    }

    static Comparator<Person> lastNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };
    static Comparator<Person> ageComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    };
}
