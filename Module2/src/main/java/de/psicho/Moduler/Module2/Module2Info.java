package de.psicho.Moduler.Module2;

import java.io.InputStream;
import java.util.Properties;

public class Module2Info {
    Properties prop;

    public String getVersionFromManifest() {
        return getClass().getPackage().getImplementationVersion();
    }

    public String getVersionFromProp() {
        loadProperties();
        return prop.getProperty("appVersion");
    }

    private void loadProperties() {
        InputStream is = getClass().getResourceAsStream("/app2.properties");
        prop = new Properties();
        try {
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
