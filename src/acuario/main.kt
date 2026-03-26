package acuario

fun construirAcuario() {
    val acuario1 = Acuario()
    acuario1.imprimirTamano()

    val acuario2 = Acuario(ancho = 25)
    acuario2.imprimirTamano()

    val acuario3 = Acuario(alto = 35, largo = 110)
    acuario3.imprimirTamano()

    val acuario4 = Acuario(ancho = 25, alto = 35, largo = 110)
    acuario4.imprimirTamano()

    val acuario5 = Acuario(numeroDePeces = 29)
    acuario5.imprimirTamano()

    acuario5.volumen = 70
    acuario5.imprimirTamano()

    val acuario6 = Acuario(largo = 25, ancho = 25, alto = 40)
    acuario6.imprimirTamano()

    val torre = TanqueTorre(diametro = 25, alto = 45)
    torre.imprimirTamano()
}

fun main() {
    construirAcuario()
}