Baue mit Profil "first".    Ergebnis: Property myProperty ist 'some value'.
Baue mit Profil "second".   Ergebnis: Property myProperty ist 'totally different'.

Kommandozeile:
    mvn -P first process-resources bzw.
    mvn -P second process-resources
Dann enth�lt target\classes\app.properties die gefilterten Ressourcen.

