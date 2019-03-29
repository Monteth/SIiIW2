import models.FutoModel
import models.SkyModel
import java.io.File

val DATA_PATH = "src/main/resources/data/"

fun readLines(filename: String) = File(DATA_PATH + filename).useLines { it.toList() }

fun getFuto(filename: String): FutoModel {
    val splittedLines = readLines(filename).map { it.split(";") }

    val problemSize = splittedLines[0][0].toInt()
    val futoStartIndex = 2
    val futoEndIndex = futoStartIndex + problemSize
    val relStartIndex = futoEndIndex + 1
    val relEndIndex = splittedLines.size

    val futoRAW = arrayListOf<ArrayList<Int>>()
    val rels = arrayListOf<Pair<String, String>>()

    splittedLines.forEachIndexed { index, row ->
        when (index) {
            in futoStartIndex until futoEndIndex ->
                futoRAW.add(row.map { it.toInt() } as ArrayList<Int>)
            in relStartIndex until relEndIndex ->
                rels.add(Pair(row[0], row[1]))
        }
    }
    return FutoModel(board = futoRAW, relations = rels)
}

fun getSky(filename: String): SkyModel {
    val lines = readLines(filename)
    return SkyModel(lines)

}