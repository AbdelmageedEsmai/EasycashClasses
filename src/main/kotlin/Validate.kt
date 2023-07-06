import java.security.MessageDigest
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


class Validate {


    fun HasConsecutive(a: String): Int {
        val asList = a.toCharArray().asList()
        val mySet = HashSet<Char>(asList)
        var frequency = 0
        run outer@{
            for (s in mySet) {
                frequency = Collections.frequency(asList, s)
                if (frequency >= 3) {
                    return@outer
                }
                println(s + " " + frequency)
            }
        }

        return frequency
    }

    fun checkRepeatingNumber(s: String): Boolean {
        val isValid = false
        val stack = Stack<Char>()
        val chars = s.toCharArray()
        var popedChar: Char? = null
        for (character in chars) {
            if (!stack.empty() && stack.peek() == character) {
                if (popedChar == character) {
                    stack.pop()
                } else
                    stack.pop()
                if (!stack.empty()) {
                    popedChar = stack.peek()
                    println("character_is :: $popedChar... $character")
                }
            } else {
                stack.push(character)
            }
        }
        println("StackSize ::: ${stack.size}")
        return stack.size < 3

//        var consecutiveSums = 0
////        val chars = s.toCharArray()
////
////        chars.forEachIndexed { index, c ->
////            if ((index + 1 < chars.size) && index != 0 && (chars[index] == chars[index])) {
////                consecutiveSums++
////            }
////        }
//
//        for (i in 1 until chars.size) {
//                if (chars[i] == chars[i - 1])
//                    consecutiveSums += 1
//        }
//        println("repeated number :: $consecutiveSums")
//
//        return consecutiveSums >= 3
    }


    fun encodingByMD5(s: String): String {
        var sEncodedString = ""
        var sDecodeString = ""
        try {
            val key = SecretKeySpec(
//                Hawk.get<String?>("result").split("$")[5]
                "5fd7431deab822475fd7431deab82247"
                    .toByteArray(charset("UTF-8")), "HmacMD5"
            )
            val mac = Mac.getInstance("HmacMD5")
            mac.init(key)
            val bytes = mac.doFinal(s.toByteArray(charset("UTF-8")))
            val hash = StringBuffer()
            for (i in bytes.indices) {
                val hex = Integer.toHexString(0xFF and bytes[i].toInt())
                if (hex.length == 1) {
                    hash.append('0')
                }
                hash.append(hex)
            }
            sEncodedString = hash.toString()
            val md = MessageDigest.getInstance("MD5")
            md.update(sEncodedString.toByteArray())
            val byteData: ByteArray = md.digest()

            val sb = StringBuffer()
            for (i in byteData.indices) sb.append(
                Integer.toString((byteData[i].toInt() and 0xff) + 0x100, 16).substring(1)
            )
            sDecodeString = sb.toString()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }



        return sDecodeString
    }

    fun checkSequence(s: String): Boolean {
        var consecutiveSums = 0
        val chars = s.toCharArray()

        chars.forEachIndexed { index, c ->
            if ((index + 1 < chars.size) && (chars[index] + 1 == chars[index + 1])) {
                consecutiveSums++
            } else if ((index + 1 < chars.size) && (chars[index] - 1 == chars[index + 1])) {
                consecutiveSums++
            }
        }

        return consecutiveSums < 5
    }
}