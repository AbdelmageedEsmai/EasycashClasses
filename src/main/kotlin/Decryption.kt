import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.Mac
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.math.roundToInt

class Decryption {

    fun setUp() {
        val listOfValues = mutableListOf<Float>()
        for (i in 100..200) {
            val number = i.toFloat() / 100
            val number2 = (number * 100f).roundToInt()
            println("$number ---- $number2")

            listOfValues.add(i.toFloat() / 100)
        }
    }

    //    fun showDecyptedDate() {
//        LogUtils.LOGE("decryptedData.. ${E345CkjasdM.decryptString("i1fi4kgVUesoG26bjRhaxA==")}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("GgQFqi0PYy3UfmlcPEm9bA=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("MkOY5WO9TKoaaTYTmBPJaw=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("zwM7XvHd3IZdk+oGuhEPcw=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("k1Sve8N6ub6jlbnm+RFUKg=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("6sbu6EtGIGLAEMLP1JTCwA=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("RdLSRze3yRsqKOdPALsrWQ=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("Tj5W8QiqrFulLEJvGjgTDg=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("tjFguEdYmcotM/873FFN6g=="))}")
//        LogUtils.LOGE("decryptedData..${E345CkjasdM.decryptString(("Ue4Kq95JDQkcNP0JfC5SSQ=="))}")
//    }

//
//    fun decryptString(encryptedText: String): String {
//
//        LogUtils.LOGE("EncryptedString :: ${Hawk.get<String?>("result").split("$")[10]}")
//        val key = SecretKeySpec(
//            Hawk.get<String?>("result").split("$")[10]
//                .decodeHex().toByteArray(), "AES"
//        )
//        val ivSpec =
//            IvParameterSpec(Hawk.get<String?>("result").split("$")[9].decodeHex().toByteArray())
//        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
//        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec)
//        val encryptedBytes = Base64.decode(encryptedText, Base64.DEFAULT)
//        val decryptedBytes = cipher.doFinal(encryptedBytes)
//        return String(decryptedBytes)
//    }
}