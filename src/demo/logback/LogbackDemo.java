package demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.net.URLClassLoader;

public class LogbackDemo {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

        logger.debug("Hello Logback");
    }
}
