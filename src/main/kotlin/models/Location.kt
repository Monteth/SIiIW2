package models

class Location(value: String) {
    val x: Int
    val y: Int

    init {
        x = charToDec(value[0])
        y = value[1].toString().toInt()
    }

    private fun charToDec(char: Char): Int {
        return (char - 64).toInt()
    }
}

