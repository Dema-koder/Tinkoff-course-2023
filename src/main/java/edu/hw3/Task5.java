package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task5 {
    public static final Logger LOGGER = LogManager.getLogger();

    public static ArrayList<String> parseContacts(String[] names, String order) {
        Comparator comparator = null;
        ArrayList<String> ans = new ArrayList<>();
        try {
            comparator = getComparator(order);
        } catch (Exception exception) {
            LOGGER.error("Не правильный формат ввода");
        }
        Map<String, String> surnames = new TreeMap<>(comparator);
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            surnames.put(parts[1], parts[0]);
        }
        for (var entry : surnames.entrySet()) {
            String name = entry.getValue();
            String surname = entry.getKey();
            String cur = name +  " " + surname;
            LOGGER.info(cur);
            ans.add(cur);
        }
        return ans;
    }

    private static Comparator<String> getComparator(String order) {
        switch (order) {
            case "ASC":
                return Comparator.naturalOrder();
            case "DESC":
                return Comparator.reverseOrder();
            default:
                throw new IllegalStateException("Unexpected value: " + order);
        }
    }
}
