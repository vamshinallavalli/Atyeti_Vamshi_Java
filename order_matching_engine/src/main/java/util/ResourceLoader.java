package util;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ResourceLoader {

    private ResourceLoader() {}

    public static Path getResourcePath(String resourceName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(resourceName);

        if (resource == null) {
            throw new IllegalArgumentException("Resource not found: " + resourceName);
        }

        try {
            URI uri = resource.toURI();
            return Paths.get(uri);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load resource: " + resourceName, e);
        }
    }
}
