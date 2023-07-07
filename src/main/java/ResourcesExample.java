import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ResourcesExample {
    public static void main(String[] args) {
        // URI - unified resource identifier
        // URL - unified resource locator

        URL url = ResourcesExample.class.getResource("/top_level_resource.txt");
        System.out.println(url);

        try (InputStream inputStream = ResourcesExample.class.getResourceAsStream("/top_level_resource.txt")) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Properties properties = new Properties();

        try (InputStream in = ResourcesExample.class.getResourceAsStream("/config/application.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(properties.getProperty("key").equals("value"));

        try (InputStream resourceAsStream = ResourcesExample.class.getResourceAsStream("/package/package_file.txt")) {
            System.out.println(resourceAsStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
