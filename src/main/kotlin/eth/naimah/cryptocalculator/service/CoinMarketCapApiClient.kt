package eth.naimah.cryptocalculator.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

class CoinMarketCapApiClient(
    private val restTemplate: RestTemplate,
    @Value("\${coinmarketcap.api.key}")
    private val apiKey: String
) {

    fun getCurrentPriceByIdOrSymbol(cryptoId: String?, cryptoSymbol: String?): BigDecimal {
        val url = urlByIdOrSymbol(cryptoId, cryptoSymbol)
        val headers = mapOf(
            "Accepts" to "application/json",
            "Accept-Encoding" to "deflate, gzip",
            "X-CMC_PRO_API_KEY" to apiKey
        )
        val response = restTemplate.getForObject(url, String::class.java, headers)
            ?: throw RuntimeException("Failed to fetch data from CoinMarketCap API")

    }

   private  fun urlByIdOrSymbol(id: String?, symbol: String?): String {
        val url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest"
        return when {
            id != null -> "$url?id=$id"
            symbol != null -> "$url?symbol=$symbol"
            else -> throw IllegalArgumentException("Both id and symbol cannot be null")
        }
    }
}