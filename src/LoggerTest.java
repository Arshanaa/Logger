/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arshanaa
 */
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Properties;

public class LoggerTest {

    private static Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    public static void main(String[] args) throws IOException {
        Logger logger = isFileLoggingEnabled() ? new FileLogger() : new ConsoleLogger();

        logger.log(timestamp.toString() + ": " + "Hello, how are you ? ");
    }

    private static boolean isFileLoggingEnabled() {
        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("logger.properties")));
            String fileLoggingProperty = properties.getProperty("FileLogging");

            return fileLoggingProperty.equalsIgnoreCase("ON");

        } catch (IOException e) {
            return false;
        }
    }

}
