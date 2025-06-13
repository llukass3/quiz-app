# Quiz-App

DISCLAIMER: wegen eines Bugs sind Anfangs- und Endscreen leider nicht implementiert.
apk datei in release-ordner.
Eine einfache Quiz-App für Android, die dem Nutzer Fragen stellt und die Antworten auswertet.

## Funktionsweise

Die App präsentiert dem Nutzer Fragen mit mehreren Antwortmöglichkeiten. Nach Auswahl einer 
Antwort wird diese überprüft und das Ergebnis (richtig/falsch) angezeigt. Der Punktestand des 
Nutzers wird dabei aktualisiert. Anschließend wird automatisch zur nächsten zufälligen Frage 
übergegangen, wobei bereits beantwortete Fragen nicht erneut gestellt werden.

**Code-Überblick:**

Die Benutzeroberfläche ist mit Jetpack Compose erstellt. Die zentrale Logik befindet sich in der 
`QuestionScreen` Composable-Funktion. Diese verwaltet den Zustand der App, wie die aktuelle Frage,
den Punktestand und die Anzahl der beantworteten Fragen. Einzelne UI-Elemente wie die Frageanzeige, 
Antwortoptionen und der Punktestand sind in separaten Composable-Funktionen gekapselt.
