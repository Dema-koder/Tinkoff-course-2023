package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashingPersonDatabase implements PersonDatabase {

    private final Map<Integer, Person> personMap;
    public final Map<String, List<Integer>> nameIndex;
    private final Map<String, List<Integer>> addressIndex;
    private final Map<String, List<Integer>> phoneIndex;

    public CashingPersonDatabase() {
        personMap = new HashMap<>();
        nameIndex = new HashMap<>();
        addressIndex = new HashMap<>();
        phoneIndex = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        personMap.put(person.id(), person);
        addToIndex(nameIndex, person.name(), person.id());
        addToIndex(addressIndex, person.address(), person.id());
        addToIndex(phoneIndex, person.phoneNumber(), person.id());
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.get(id);
        if (person != null) {
            removeFromIndex(nameIndex, person.name(), person.id());
            removeFromIndex(addressIndex, person.name(), person.id());
            removeFromIndex(phoneIndex, person.name(), person.id());
            personMap.remove(id);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        List<Integer> ids = nameIndex.getOrDefault(name, new ArrayList<>());
        return getPersonsByIds(ids);
    }

    @Override
    public List<Person> findByAddress(String address) {
        List<Integer> ids = addressIndex.getOrDefault(address, new ArrayList<>());
        return getPersonsByIds(ids);
    }

    @Override
    public List<Person> findByPhone(String phone) {
        List<Integer> ids = phoneIndex.getOrDefault(phone, new ArrayList<>());
        return getPersonsByIds(ids);
    }

    private void addToIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.getOrDefault(key, new ArrayList<>());
        if (!ids.contains(id)) {
            ids.add(id);
            index.put(key, ids);
        }
    }

    private void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.getOrDefault(key, new ArrayList<>());
        ids.remove(Integer.valueOf(id));
        if (ids.isEmpty()) {
            index.remove(key);
        } else {
            index.put(key, ids);
        }
    }

    private List<Person> getPersonsByIds(List<Integer> ids) {
        List<Person> persons = new ArrayList<>();
        for (var id : ids) {
            Person person = personMap.get(id);
            if (person != null) {
                persons.add(person);
            }
        }
        return persons;
    }
}
