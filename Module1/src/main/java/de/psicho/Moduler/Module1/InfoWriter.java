package de.psicho.Moduler.Module1;

import java.io.InputStream;
import java.util.Properties;

import de.psicho.Moduler.Module2.Module2Info;
import de.psicho.Moduler.Module3.Module3Info;

public class InfoWriter {
    Properties prop;

    public void write() {
        loadProperties();
        Module2Info info2 = new Module2Info();
        Module3Info info3 = new Module3Info();
        System.out.println("Module1: Manifest=" + getClass().getPackage().getImplementationVersion() + " Prop=" + prop.getProperty("appVersion"));
        System.out.println("Module2: Manifest=" + info2.getVersionFromManifest() + " Prop=" + info2.getVersionFromProp());
        System.out.println("Module3: Manifest=" + info3.getVersionFromManifest() + " Prop=" + info3.getVersionFromProp());
    }
    
    private void loadProperties() {
        InputStream is = getClass().getResourceAsStream("/app1.properties");
        prop = new Properties();
        try {
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
