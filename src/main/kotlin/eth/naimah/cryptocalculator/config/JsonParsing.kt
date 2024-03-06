package eth.naimah.cryptocalculator.config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


class JsonParsing {

    val mapper = jacksonObjectMapper()

    fun serializeContent(jsonString: String) {
        val model: Map<String, Any?> = mapper.readValue(jsonString)
        return model
    }
}