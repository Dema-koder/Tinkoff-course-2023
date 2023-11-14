package edu.hw3;

import org.jetbrains.annotations.NotNull;

public class Contacts implements Comparable<Contacts> {
    private String name;
    private String surname = "null";

    public Contacts(String contact) {
        Task5.LOGGER.info(contact);
        String[] parts = contact.split(" ");
        Task5.LOGGER.info(parts[0]);
        Task5.LOGGER.info(parts[1]);
        this.name = parts[0];
        if (parts.length > 1) {
            this.surname = parts[1];
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(@NotNull Contacts o) {
        if (surname.equals(o.getSurname())) {
            return (name).compareTo(o.getName());
        } else {
            return surname.compareTo(o.getSurname());
        }
    }

    @Override public String toString() {
        return name + '\'' + surname;
    }
}
