package edu.hw2;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {

    private static final Logger LOGGER = LogManager.getLogger();

    // через него происходит работа с сервером
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    // работает всегда
    public static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
            LOGGER.info("Выполнение команды на стабильном соединении:  " + command);
        }

        @Override
        public void close() throws Exception {
            LOGGER.info("Закрытие стабильного соединения");
        }
    }

    // иногда бросает ConnectionException
    public static class FaultyConnection implements Connection {
        private final Random random = new Random();

        @Override
        public void execute(String command) throws ConnectionException {
            if (random.nextBoolean()) {
                throw new ConnectionException("Ошибка соединения при выполнении команды: " + command);
            } else {
                LOGGER.info("Выполнение команды на проблемном соединении: " + command);
            }
        }

        public void close() throws Exception {
            LOGGER.info("Закрытие проблемного соединения");
        }
    }

    // используется чтобы получить соединение
    public interface ConnectionManager {
        Connection getConnection();
    }

    // с некоторой вероятностью возвращает проеблемное соединение
    public static class DefaultConnectionManager implements ConnectionManager {
        private final Random random = new Random();

        @Override
        public Connection getConnection() {
            if (random.nextBoolean()) {
                return new FaultyConnection();
            }
            return new StableConnection();
        }
    }

    // всегда возвращает проблемное соединение
    public static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    // может возникнуть при выполнении команды
    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }

        public ConnectionException(String message) {
            super(message);
        }
    }

    public static final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {
            for (int i = 0; i < maxAttempts; i++) {
                try {
                    Connection connection = manager.getConnection();
                    connection.execute(command);
                    return;
                } catch (ConnectionException exception) {
                    LOGGER.error("Ошибка соединения. Попытка " + (i + 1) + " из " + maxAttempts);
                    if (i == maxAttempts - 1) {
                        throw new ConnectionException("Не удалось выполнить команду", exception);
                    }
                }
            }
        }
    }
}
