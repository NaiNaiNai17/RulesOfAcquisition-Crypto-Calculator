package eth.naimah.cryptocalculator.model

import java.math.BigDecimal

data class PriceResponse(
    val cryptoCurrencyType: String,
    val fiatCurrencyType: String,
    val currentPrice: BigDecimal,
    val originalBuyingPrice: BigDecimal = currentPrice,
    val desiredPriceTarget: BigDecimal,
    val profitPrice: BigDecimal,
)