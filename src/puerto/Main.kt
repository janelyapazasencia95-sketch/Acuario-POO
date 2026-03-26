package puerto

open class VehiculoMarino(
    open var nombre: String,
    open var capacidad: Int = 2
) {
    init {
        println("Inicializando vehículo marino...")
    }
    constructor(nombre: String, capacidad: Int, pasajerosIniciales: Int) : this(nombre, capacidad) {
        pasajeros = pasajerosIniciales
    }
    open val tipo = "vehículo marino"
    open var pasajeros: Int = 0
        set(value) {
            field = when {
                value < 0 -> 0
                value > capacidad -> capacidad
                else -> value
            }
        }
    open val espaciosDisponibles: Int
        get() = capacidad - pasajeros
    open fun mostrarInfo() {
        println("Tipo: $tipo")
        println("Nombre: $nombre")
        println("Capacidad: $capacidad")
        println("Pasajeros actuales: $pasajeros")
        println("Espacios disponibles: $espaciosDisponibles")
        println()
    }
}
interface Navegable {
    fun navegar()
}
abstract class Tripulante {
    abstract val rol: String
    abstract fun trabajar()
}
class Lancha(
    nombre: String,
    capacidad: Int = 4
) : VehiculoMarino(nombre, capacidad), Navegable {
    override val tipo = "lancha"
    override fun navegar() {
        println("$nombre está navegando cerca del puerto.")
    }
}

class BarcoPesquero(
    nombre: String,
    capacidad: Int = 6
) : VehiculoMarino(nombre, capacidad), Navegable {

    override val tipo = "barco pesquero"
    override fun navegar() {
        println("$nombre está saliendo a zona de pesca.")
    }
}
class Capitan(
    val nombreCapitan: String
) : Tripulante() {

    override val rol: String = "capitán"
    override fun trabajar() {
        println("$nombreCapitan está dirigiendo la ruta del vehículo.")
    }
}
fun main() {
    println("=== SISTEMA DE PUERTO MARÍTIMO ===")
    println()
    val lancha = Lancha("Mar Azul", 4)
    lancha.pasajeros = 3
    lancha.mostrarInfo()
    lancha.navegar()
    println()
    val barco = BarcoPesquero("Océano Sur", 6)
    barco.pasajeros = 8
    barco.mostrarInfo()
    barco.navegar()

    println()
    val vehiculoSecundario = VehiculoMarino("Lancha Escolar", 5, 2)
    vehiculoSecundario.mostrarInfo()
    val capitan = Capitan("Luis")
    capitan.trabajar()
}