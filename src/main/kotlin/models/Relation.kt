package models

class Relation(pair: Pair<String, String>) {
    val smaller: Location = Location(pair.first)
    val bigger: Location = Location(pair.second)
}