package acuario

fun construirAcuario() {
}
fun crearPeces() {
    val tiburon = Tiburon()
    val pezPayaso = PezPayaso()
    println("Color del tiburon: ${tiburon.color}")
    println("Color del pez payaso: ${pezPayaso.color}")
}
fun main() {
    construirAcuario()
    crearPeces()
}