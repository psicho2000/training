Using examples from
    http://stackoverflow.com/questions/7414794/difference-between-contextannotation-config-vs-contextcomponent-scan
    http://stackoverflow.com/questions/12899372/spring-why-do-we-autowire-the-interface-and-not-the-implemented-class
    http://stackoverflow.com/questions/7812745/spring-qualifier-and-property-placeholder

OldStyle
    Example for declaring all beans in xml

AnnotationConfig
    Example for Autowiring with annotation-config --> less xml   

ComponentScan
    Example for Autowiring with component-scan --> minimal xml
    Demonstrates use of aliases
    a) ContentGenerator: configure implemented interface using @Qualifier annotation
    b) ConfigurableContentGenerator: configure implemented interface via maven profile 

Usage
    1. Compile with profile test (= default) or prod
    2. Run with java -jar target/Injector.Advanced-1.0.0-SNAPSHOT-jar-with-dependencies.jar
    3. Demo of Autowiring for Demo* in x.AnnotationConfig, x.ComponentScan, x.OldStyle can be seen during Spring ApplicationContext loading (where x=de.psicho.Injector.Advanced)
    4. Demo for (Configurable)ContentGenerator is started explicitly in AppMain 