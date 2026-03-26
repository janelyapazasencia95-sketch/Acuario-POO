package acuario
abstract class Pez {
    abstract val color: String
}
class Tiburon : Pez() {
    override val color: String = "gris"
}
class PezPayaso : Pez() {
    override val color: String = "dorado"
}
