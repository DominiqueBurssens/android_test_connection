const express = require('express')
const http = require('http')
const https = require('https')
const fs = require('fs')

const app = express()

const port = 3000
const httpsPort = 4000

const sslOptions = {
    key: fs.readFileSync('key.pem'),
    cert: fs.readFileSync('cert.pem'),
    passphrase: 'test'
}

app.get('/', (request, response) => {
    response.send('Connectie naar server werkt!')
})

const httpServer = http.createServer(app)
httpServer.listen(port, 'localhost', () =>
    console.log(`Listening on localhost: ${port}`)
)

const httpsServer = https.createServer(sslOptions, app)
httpsServer.listen(httpsPort, 'localhost', () =>
    console.log(`Listening securely on localhost: ${httpsPort}`)
)
