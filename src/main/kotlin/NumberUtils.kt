import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*
import kotlin.math.sign

class NumberUtils {

    fun scaleType(number: Float): String {
        val scale = number * 100
        return scale.toString()
    }

    fun convertArabicNumbersToEnglish(str: String): String {
        var newStr = ""
        for (c in str) {
            newStr += when (c) {
                '٠' -> '0'
                '١' -> '1'
                '٢' -> '2'
                '٣' -> '3'
                '٤' -> '4'
                '٥' -> '5'
                '٦' -> '6'
                '٧' -> '7'
                '٨' -> '8'
                '٩' -> '9'
//                ',' -> '.'
                else -> c
            }
        }
        return newStr
    }

    fun formatFloatToIntegerAmount(number: Float): Int {
        val split = number.toString().split(".")
        var pStr = split[1]
        if (pStr.length == 1) {
            pStr += "0"
        } else if (pStr.length > 2) {
            pStr = pStr.substring(0, 2)
        }
        val finalString = split[0] + pStr
        return finalString.toInt()
    }

    fun sumAmountToFees(number: Float): Float {
        val split = number.toString().split(".")
        var pStr = split[1]
        if (pStr.length == 1) {
            pStr += "0"
        } else if (pStr.length > 2) {
            pStr = pStr.substring(0, 2)
        }
        val finalString = split[0] + "." + pStr
        return finalString.toFloat()

    }


    fun roundDown(d: Float, roundingMode: RoundingMode?): String {
        val symbols = DecimalFormatSymbols(Locale.US)
        val df = DecimalFormat("#.00", symbols)
        if (roundingMode != null) {
            df.roundingMode = roundingMode
        }

        return df.format(d)
    }

}