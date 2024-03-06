package main.kotlin.eth.naimah.cryptocalculator

import org.springframework.stereotype.Service
import java.math.BigDecimal


@Service
internal class CryptoCalculatorService {
    fun calculateProfit(originalPrice: BigDecimal, unit: BigDecimal,  desiredPriceTarget: BigDecimal): BigDecimal =
        ((desiredPriceTarget - originalPrice) * unit)

}