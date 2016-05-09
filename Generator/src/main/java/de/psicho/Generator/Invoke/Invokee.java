package de.psicho.Generator.Invoke;

public class Invokee {
    public String Hello(String appendix) {
        return "Hellllooooo! " + appendix;
    }
    
    public String World(String appendix) {
        return "Woreld " + appendix;
    }
    
    public static String Hello() {
        return "Hellllooooo!";
    }
    
    public static String World() {
        return "Woreld";
    }

}
