# Android connect localhost

In deze repository vind je twee mini-projectjes terug die je kan gebruiken om de
HTTP(S) connectie te testen tussen je Android emulator (of *echt* device) en een
server op *localhost*.

## Server

[server](server)

Benodigdheden: NodeJs en NPM.

De server opstarten kan je doen als volgt. We doen dit vanop de **command line**.  
1. Navigeer naar directory "server" (bijvoorbeeld `cd server`)
2. `npm install`
3. `npm run start`

By default is de poort **3000** voor HTTP en **4000** voor HTTPS. Je kan deze aanpassen in `src/index.js`.

**Test de werking uit met een browser door te surfen naar [http://localhost:3000](http://localhost:3000) en [https://localhost:4000](https://localhost:4000)**. In het geval van HTTPS zal je browser je vragen 
of je wel wil voortgaan omdat het certificaat niet van een officiële instantie komt. Hier moet je dus
akkoord gaan en verderzetten.

## Android app

[LocalhostApp](LocalhostApp)

Open het project in Android Studio en voer uit.

Indien je de app uitvoert op een emulator kan je de default invoerwaarden laten staan.
Dus **host 10.0.2.2** en **port 3000** (tenzij je deze in de server hebt aangepast).  
Druk op "CONNECT". Het resultaat zou moeten overeenkomen met één van de twee screenshots
hieronder. Dus *"Connectie naar server werkt!"* **of** *"GEEN"*.

![/images/werkt.png](/images/werkt.png)

![/images/werkt_niet.png](/images/werkt_niet.png)

Als je een HTTPS connectie wil testen maak je gebruik van **port 4000** en zet je **HTTPS** aan.

![/images/werkt_https.png](/images/werkt_https.png)

## Info

Het SSL certificaat werd aangemaakt met volgend commando:
```
openssl req -x509 -newkey rsa:2048 -keyout key.pem -out cert.pem -days 9999
```
Het wachtwoord (eigenlijk *passphrase*) is 'test'.

# SSL certificaat

Een echt SSL certificaat hoef je niet te ondersteunen. Voor meer info kan je o.a. hier terecht:  
[https://developer.android.com/training/articles/security-ssl](https://developer.android.com/training/articles/security-ssl)
... en bij [Let's Encrypt](https://letsencrypt.org/).
