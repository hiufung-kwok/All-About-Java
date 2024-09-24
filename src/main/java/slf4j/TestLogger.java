package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test slf4j binding.
 */
public class TestLogger {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(TestLogger.class);
        logger.info("Hello World");

    }
}
