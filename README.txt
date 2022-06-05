# Laboratorio-B
Versione 2.0 del progetto centri vaccinali

Componenti necessarie :
- necessario maven, istruzioni per l'installazione : https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- JRE (Java Runtime Environment) o JDK (Java Development Kit). Istruzioni per l'installazione: https://www.oracle.com/downloads/index.htm

Dati di default di accesso al database :
- url : jdbc:postgresql://127.0.0.8/laboratorio
- user : postgres
- password : admin
N.B. Se si desidera cambiare tali dati bisogna modificare il file pom.xml presente nella cartella "\Server_Centri_Vaccinali" e poi dopo aver avviato l'app server modificarli anche lì seguendo le istruzioni su console



Prima del primo avvio :
- aprire cmd
- spostarsi sulla directory "Server_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Server_Centri_Vaccinali
- scrivere su console : mvn clean install
- aspettare che il comando finisca di essere eseguito
- seguire istruzioni per creazione database
- aprire cmd
- spostarsi sulla directory "Client_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Client_Centri_Vaccinali
- scrivere su console : mvn clean install
- aspettare che il comando finisca di essere eseguito


Istruzioni per creazione database :
- aprire cmd
- spostarsi sulla directory "Server_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Server_Centri_Vaccinali
- per connettersi al server del database e creare un nuovo db, scrivere su console : mvn org.codehaus.mojo:sql-maven-plugin:execute
	se come risultato si ha "Build failure" aprire il file pom.xml(tramite qualsiasi editor di testo) presente nella cartella Server_Centri_Vaccinali e modificare i dati di accesso al server db (url, username, password)


Istruzioni per avvio server :
- aprire cmd
- spostarsi sulla directory "Server_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Server_Centri_Vaccinali
- per avviare il server, scrivere su console : mvn exec:java@second-cli
	A server avviato verrà chiesto se si vuole modificare i dati di accesso al database (url, username, password)
	Se si riscontrano errori controllare che i dati di accesso inseriti o presenti nel file pom.xml nella cartella Server_Centri_Vaccinali siano corretti ed eventualmente seguire le istruzione per la creazione del database

Istruzioni per avvio client :
- aprire cmd
- spostarsi sulla directory "Client_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Client_Centri_Vaccinali
- per avviare il client scrivere su console : mvn exec:java@default-cli

	
Istruzioni per la generazione della javadoc Server :
- aprire cmd
- spostarsi sulla directory "Server_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Server_Centri_Vaccinali
- per generare la javadoc : mvn javadoc:aggregate

Istruzioni per la generazione della javadoc Client :
- aprire cmd
- spostarsi sulla directory "Client_Centri_Vaccinali" scrivendo su console : cd ...\Laboratorio B\Client_Centri_Vaccinali
- per generare la javadoc : mvn javadoc:aggregate