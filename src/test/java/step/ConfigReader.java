package step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;
    private static final String CONFIG_FILE = "src/test/java/resources/test.properties";

    public static String getThreadCount() {
        return getProperty("threadCount", "1");
    }

    public static String getBrowser() {
        return getProperty("browser", "chrome");
    }
//    public static String openLoginPage() {
//     return getProperty("url");
//    }

    private static String getProperty(String propertyName, String defaultValue) {
        prop = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            prop.load(input);
            return prop.getProperty(propertyName, defaultValue);
        } catch (IOException e) {
            e.printStackTrace();
            return defaultValue;
        }

    }
}
