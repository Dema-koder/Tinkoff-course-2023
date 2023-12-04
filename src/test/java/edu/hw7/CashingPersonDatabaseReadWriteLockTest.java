package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.*;

class CashingPersonDatabaseReadWriteLockTest {
    @Test
    @DisplayName("Test without deletes")
    public void testConcurrency() {
        CashingPersonDatabaseReadWriteLock database = new CashingPersonDatabaseReadWriteLock();
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 1000; i++) {
            Person person = new Person(i, "Name" + i, "Address" + i, "Phone" + i);
            database.add(person);
        }

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                assertEquals(1, database.findByName("Name1").size());
                assertEquals(1, database.findByAddress("Address1").size());
                assertEquals(1, database.findByPhone("Phone1").size());
            });
        }
        executorService.shutdown();
    }

    @Test
    @DisplayName("Test with deletes")
    public void testConcurrencyWithDeletes() {
        CashingPersonDatabaseReadWriteLock database = new CashingPersonDatabaseReadWriteLock();
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 1000; i++) {
            Person person = new Person(i, "Name" + i, "Address" + i, "Phone" + i);
            database.add(person);
        }

        database.delete(1);

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                assertEquals(0, database.findByName("Name1").size());
                assertEquals(0, database.findByAddress("Address1").size());
                assertEquals(0, database.findByPhone("Phone1").size());
            });
        }
        executorService.shutdown();
    }
}
