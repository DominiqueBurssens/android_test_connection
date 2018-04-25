const express = require('express')
const app = express()
const port = 3000

app.get('/', (request, response) => {
    response.send('Connectie naar server werkt!')
})

app.listen(port, 'localhost', e =>
    console.log(`Listening on localhost:${port}`)
)
