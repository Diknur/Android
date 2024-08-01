package com.example.tugas3apisidik

import com.google.gson.Gson
import org.w3c.dom.Document
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import java.io.File

data class Superhero(
    val id: Int,
    val name: String,
    val powerstats: PowerStats
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

fun main() {
    val url = "https://superheroapi.com/id/226"
    val response = requests.get(url)
    val superhero = Gson().fromJson(response.text, Superhero::class.java)

    // Membuat dokumen XML
    val docFactory = DocumentBuilderFactory.newInstance()
    val docBuilder = docFactory.newDocumentBuilder()
    val doc: Document = docBuilder.newDocument()

    // Elemen root
    val superheroElement = doc.createElement("superhero")
    doc.appendChild(superheroElement)

    // Elemen id
    val idElement = doc.createElement("id")
    idElement.appendChild(doc.createTextNode(superhero.id.toString()))
    superheroElement.appendChild(idElement)

    // Elemen name
    val nameElement = doc.createElement("name")
    nameElement.appendChild(doc.createTextNode(superhero.name))
    superheroElement.appendChild(nameElement)

    // Elemen powerstats
    val powerstatsElement = doc.createElement("powerstats")
    superheroElement.appendChild(powerstatsElement)


    val transformerFactory = TransformerFactory.newInstance()
    val transformer: Transformer = transformerFactory.newTransformer()
    val source: DOMSource = DOMSource(doc)
    val file = File("superhero.xml")
    val result = StreamResult(file)
    transformer.transform(source, result)

    println("XML file created: ${file.absolutePath}")
}