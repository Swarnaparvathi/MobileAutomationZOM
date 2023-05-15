package Utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Swarnaparvathi
 * Created On 15/05/23
 */
public class ReadProperties {

    public Properties properties = new Properties();
    private File file;
    private int count = 0;

    public void readFile(File file) throws Exception {
        setFile(file);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(this.file));
        this.properties.load(bis);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    /**
     * @param property
     * @return
     */
    public String getValue(String property) {
        if (count > 0) {
            return this.properties.getProperty(count + property);

        } else {
            return this.properties.getProperty(property);
        }
    }

    public static String getPropertyValue(String fileName, String propertyName) {
        Properties prop = new Properties();
        String value = null;

        try (InputStream inputConfig = ClassLoader.getSystemResourceAsStream(fileName);) {
            prop.load(inputConfig);

            value = prop.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Value corrosponding to the key is not present in the config.properties file ");
            e.printStackTrace();
        }
        return value;
    }

}
