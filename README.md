# Android connect localhost

In deze repository vind je twee mini-projectjes terug die je kan gebruiken om de
HTTP connectie te testen tussen je Android emulator (of *echt* device) en een
server op *localhost*.

## Server

[server](server)  
Benodigdheden: NodeJs en NPM.

De server opstarten kan je doen als volgt. We doen dit vanop de **command line**.  
1. Navigeer naar directory "server" (bijvoorbeeld `cd server`)
2. `npm install`
3. `npm run start`

By default is de poort 3000. Je kan deze aanpassen in `src/index.js`.

**Test de werking uit met een browser door te surfen naar [http://localhost:3000](http://localhost:3000)**.

## Android app

[LocalhostApp](LocalhostApp)

Open het project in Android Studio en voer uit.

Indien je de app uitvoert op een emulator kan je de default invoerwaarden laten staan.
Dus **host 10.0.2.2** en **port 3000** (tenzij je deze in de server hebt aangepast).  
Druk op "CONNECT". Het resultaat zou moeten overeenkomen met één van de twee screenshots
hieronder. Dus *"Connectie naar server werkt!"* of *"GEEN"*.

![/images/werkt.png](/images/werkt.png)

![/images/werkt_niet.png](/images/werkt_niet.png)

