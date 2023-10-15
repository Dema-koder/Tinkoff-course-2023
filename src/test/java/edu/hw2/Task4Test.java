package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;

import static edu.hw2.Task4.callingInfo;
import static org.junit.jupiter.api.Assertions.*;
import edu.hw2.Task4.*;

class Task4Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void callingInfoTest() {
        CallingInfo callInfo = callingInfo();
        LOGGER.info(callInfo);
        assertEquals("edu.hw2.Task4Test", callInfo.className());
        assertEquals("callingInfoTest", callInfo.methodName());
    }
}
