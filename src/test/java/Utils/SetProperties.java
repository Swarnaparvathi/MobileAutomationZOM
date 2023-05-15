package Utils;

import java.io.File;

/**
 * @author Swarnaparvathi
 * Created On 15/05/23
 */

public class SetProperties {

    public static ReadProperties appConfig;

    public SetProperties() {
        try {
            appConfig = new ReadProperties();

            // Read appConfig properties file
            appConfig.readFile(new File("src/test/java/PropertyFiles/appConfig.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getObjectReference(String objReference) {

        throw new IllegalArgumentException("Selected object doesn't exist");
    }
}