package me.selemba.colorDialog

open class DialogColor(val red: Int, val green: Int, val blue: Int) {
    fun toHex(): String {
        return "#${red.toString(16).takeLast(2)}${green.toString(16).takeLast(2)}${blue.toString(16).takeLast(2)}"
    }

    companion object {
        fun fromHex(hex: String): DialogColor {
            val cut = hex.substring(1)
            val red = cut.substring(0, 3).toInt(16)
            val green = cut.substring(3, 5).toInt(16)
            val blue = cut.substring(5).toInt(16)
            return DialogColor(red, green, blue)
        }
    }
}