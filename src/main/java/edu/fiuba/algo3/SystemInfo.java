package edu.fiuba.algo3;

import java.net.URL;
import java.nio.file.Paths;

public class SystemInfo {

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

    public static URL getResourceURL(String path) {
        return SystemInfo.class.getResource(Paths.get(path).toUri().getPath());
    }

}
