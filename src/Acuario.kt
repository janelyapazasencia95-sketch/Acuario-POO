package acuario

import kotlin.math.PI

open class Acuario(
    open var largo: Int = 100,
    open var ancho: Int = 20,
    open var alto: Int = 40
) {

    init {
        println("inicializando acuario")
    }

    constructor(numeroDePeces: Int) : this() {
        val tanque = numeroDePeces * 2000 * 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }

    open var volumen: Int
        get() = ancho * alto * largo / 1000
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    open val forma = "rectángulo"

    open var agua: Double = 0.0
        get() = volumen * 0.9

    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm")
        println("Largo: $largo cm")
        println("Alto: $alto cm")
        println("Volumen: $volumen l")
        println("Agua: $agua l (${agua / volumen * 100.0}% lleno)")
        println()
    }
}

class TanqueTorre(
    override var alto: Int,
    var diametro: Int
) : Acuario(alto = alto, ancho = diametro, largo = diametro) {

    override var volumen: Int
        get() = (((ancho / 2.0) * (largo / 2.0) * alto * PI) / 1000).toInt()
        set(valor) {
            alto = ((valor * 1000 / PI) / ((ancho / 2.0) * (largo / 2.0))).toInt()
        }

    override var agua: Double = 0.0
        get() = volumen * 0.8

    override val forma = "cilindro"
}