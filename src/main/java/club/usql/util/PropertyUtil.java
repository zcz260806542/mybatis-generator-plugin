package club.usql.util;

import club.usql.exception.GeneratorException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author far.liu
 */
public class PropertyUtil {
    private static Properties properties;

    static {
        InputStream resource = null;
        try {
            resource = PropertyUtil.class.getClassLoader().getResourceAsStream("application.yml");
            properties.load(resource);
        } catch (IOException e) {
            throw new GeneratorException(e.getMessage(), e);
        } finally {
            if (resource != null) {
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
