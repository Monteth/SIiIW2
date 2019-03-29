package models

class SkyModel(list: List<String>){
    val topLimits = filterLimits('G', list)
    val bottomLimits =filterLimits('D', list)
    val leftLimits = filterLimits('L', list)
    val rightLimits = filterLimits('P', list)

    private fun filterLimits(char: Char, list: List<String>): List<Int>{
        return list.first { it[0] == char }.split(";").asReversed().dropLast(1).asReversed().map { it.toInt() }
    }
}