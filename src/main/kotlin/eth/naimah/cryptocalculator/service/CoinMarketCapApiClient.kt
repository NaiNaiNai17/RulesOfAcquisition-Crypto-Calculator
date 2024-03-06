package eth.naimah.cryptocalculator.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal

class CoinMarketCapApiClient(
    private val restTemplate: RestTemplate,
    @Value("\${coinmarketcap.api.key}")
    private val apiKey: String
) {

    fun getCurrentPriceById(cryptoId: String): BigDecimal {
        val url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=$cryptoId"
        val headers = mapOf("X-CMC_PRO_API_KEY" to apiKey)
        val response = restTemplate.getForObject(url, String::class.java, headers)
            ?: throw RuntimeException("Failed to fetch data from CoinMarketCap API")


    }
}