package utils;

import java.util.Properties;

public class ReadFromUserData {
    private static final Properties prop = new Properties();

    public static String getValueFromConfig(String value, String propertiesName) {
        try {
            prop.load(ReadFromUserData.class.getClassLoader().getResourceAsStream(propertiesName));
        } catch (Exception e) {
            System.out.println(e);
        }
        return prop.getProperty(value);
    }

}
