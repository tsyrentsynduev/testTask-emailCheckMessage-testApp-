package utils;

import java.io.IOException;
import java.util.Properties;

public class ReadFromUserData {
    private static final Properties prop;

    static {
        prop = new Properties();
        try {
            prop.load(ReadFromUserData.class.getClassLoader().getResourceAsStream("UserData.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getValueFromConfig(String value) {
        return prop.getProperty(value);
    }

}
