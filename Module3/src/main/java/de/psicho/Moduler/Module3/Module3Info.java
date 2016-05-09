package de.psicho.Moduler.Module3;

import java.io.InputStream;
import java.util.Properties;

public class Module3Info {
    Properties prop;
    
    public String getVersionFromManifest() {
        return getClass().getPackage().getImplementationVersion();
    }
    
    public String getVersionFromProp() {
        loadProperties();
        return prop.getProperty("appVersion");
    }
    
    public String getResource() {
        return getClass().getResource("/app3.properties").toString();
    }
    
    private void loadProperties() {
        InputStream is = getClass().getResourceAsStream("/app3.properties");
        prop = new Properties();
        try {
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
