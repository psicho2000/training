package de.psicho.ResourceFiltering;

import java.io.InputStream;
import java.util.Properties;

public class Filter {
    Properties prop;

    public void perform() {
        loadProperties();

        System.out.println(prop.getProperty("myProperty"));
        System.out.println(prop.getProperty("application.groupId") + '.' + prop.getProperty("application.artifactId") + '-'
                + prop.getProperty("application.version"));
    }

    private void loadProperties() {
        prop = new Properties();
        try(InputStream is = getClass().getResourceAsStream("/app.properties")) {
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
