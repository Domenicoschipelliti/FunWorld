# FunWorld

Buongiorno sono Domenico Schipelliti ,sono un ragazzo di 21 anni che sta finendo il percorso con Epicode . Visto che mi piacciono gli anime, voglio fare una cosa simile a Myanimelist ovvero liste di anime/manga  nella quale si può visualizzare l'indice di gradimento nelle categorie apposite e anche poterle creare da un form da parte dell'utente e tutto questo verrà organizzato in React con eventuali icone e stili prese da Bootstrap. Ovviamente verranno precedute da una parte di register e login che comunicherà con il database PostgreSQL usando Java.

#Come farlo funzionare

Back-End:
Quando copierete il progetto , vi serve una cosa fondamentale che sarebbero i dati delicati da mettere possibilmente in un file .properties ignorato dal gitignore scrivendo il percorso file se è messo in una cartella se no direttamente potete mettere il nome. Al suo interno seguendo i nomi dati dalle variabili nell'application properties che è dentro src/main/resources/application.properties:

spring.config.import=file:nome-file(ignorato),

server.port=${NUMERO_PORTA}=numero del server in cui gira,

spring.datasource.username=${UTENTE}= nome utente messo sul database, 

spring.datasource.password=${PASSWORD}= Password del database,

spring.datasource.url=${NOMEHOST_NOMESERVER}=nome del database,

spring.datasource.driver-class-name=${DRIVER}=Driver del database,

spring.jpa.hibernate.ddl-auto=${DDL}=controllo della gestione delle tabelle/schemi del database(se uno vuole aggiornare le tabelle consiglio update),

spring.jpa.properties.hibernate.default_schema=${DEFAULT_SCHEMA}=lo schema utilizzato nel database per l'accesso,

spring_JwT_key=${JwT_key}=serve per spring security dare una chiave per evitare gente non consona ad averlo (consiglio più lunga possibile).

#Cloudinary
IO per l'upload delle immagini ho usato Cloudinary con il piano gratis ma se volete usarne un altro fate voi , tenete conto che dovrete modificare la cartella cloudinary di configuarzione , service e controlles che lo usano.
# Cloudinary config
cloudinary.name=${CLOUDINARY_NAME}=nome del profilo, 

cloudinary.apikey=${CLOUDINARY_API_KEY}=api_key di Cloudinary,

cloudinary.secret=${CLOUDINARY_SECRET}=codice segreto di Cloudinary.

#Nota tutte queste cose verrano date da cLoudinary dopo la registrazione dal sito.

Per Istruzioni sul Front-End andate qui:
https://github.com/Domenicoschipelliti/funword/blob/master/README.md








