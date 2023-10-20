package edu.hw2;

import org.junit.jupiter.api.Test;
import edu.hw2.Task3.*;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    public void testUpdatePackages() {
        ConnectionManager manager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);

        executor.updatePackages();
    }

    @Test
    public void testTryExecute_SuccessfulExecution() {
        ConnectionManager manager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);

        executor.tryExecute("apt update");
    }

    @Test
    public void testTryExecute_ConnectionException() {
        ConnectionManager manager = new FaultyConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);

        executor.tryExecute("apt update");
    }
}
