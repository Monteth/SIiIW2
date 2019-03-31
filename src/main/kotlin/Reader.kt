import models.FutoModel
import models.Location
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

    val futoRAW: MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>()
    val rels = arrayListOf<Pair<String, String>>()

    splittedLines.forEachIndexed { index, row ->
        when (index) {
            in futoStartIndex until futoEndIndex ->
                futoRAW.add(row.map { it.toInt() } as ArrayList<Int>)
            in relStartIndex until relEndIndex ->
                rels.add(Pair(row[0], row[1]))
        }
    }
    println(Location("D1").x)
    println(Location("D1").y)
    println(futoRAW.get(Location("D1")))
    return FutoModel(board = futoRAW, relations = rels)
}

private fun <E> List<List<E>>.get(location: Location): E {
    return this[location.y -1][location.x -1]
}


fun getSky(filename: String): SkyModel {
    val lines = readLines(filename)
    return SkyModel(lines)

}