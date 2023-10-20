package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("hideutilityclassconstructor")
public class Task4 {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int REQUIRED_INDEX_OF_STACK_TRACE = 3;

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            LOGGER.info(stackTrace[i].getClassName() + ' ' + stackTrace[i].getMethodName());
        }
        if (stackTrace.length >= REQUIRED_INDEX_OF_STACK_TRACE) {
            String className = stackTrace[2].getClassName();
            String methodName = stackTrace[2].getMethodName();
            return new CallingInfo(className, methodName);
        }
        return null;
    }

    public record CallingInfo(String className, String methodName) {
    }

}
