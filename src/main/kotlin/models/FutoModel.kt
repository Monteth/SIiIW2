package models

class FutoModel(val board: List<List<Int>>, relations: ArrayList<Pair<String, String>>){
    val relations: List<Relation> = relations.map { Relation(it) }
}