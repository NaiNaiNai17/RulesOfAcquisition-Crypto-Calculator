package eth.naimah.cryptocalculator.model

import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class PriceRequest(
    @NotBlank
    val cryptoCurrencyType: String,
    @NotBlank
    val fiatCurrencyType: String,
    val currentPrice: BigDecimal,
    val originalBuyingPrice: BigDecimal = currentPrice,
    val desiredPriceTarget: BigDecimal,
)
