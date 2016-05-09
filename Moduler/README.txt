Build parent with versions:set -DnewVersion=xxx
Build parent with clean install to install all modules.

In directory delivery, run with
    java -cp Module1.jar de.psicho.Moduler.Module1.MainApp
    java -jar Module1.jar
    
Module 1: inherits version from parentVersion=xxx to set versions of parent and some child modules.
Module 2: has copy of parent's version
Module 3: implements own version

Demonstrates:
*   reading and writing versions in MANIFEST.MF
*   define mainClass
*   copy all jars in main directory delivery
 
ToDos
*   generalize addDefaultImplementationEntries and addDefaultSpecificationEntries into parentPom.

Remarks
*   When having multiple app.properties with same name, first one found is taken (instead of the current project one).
    Use getClass().getResource("/app3.properties").toString() to tell which one is taken.
