package app2
import kotlin.math.sqrt

const val EPS = 0.0000001

class Complex(val real: Double, val imaginary: Double) {

    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())

    override fun toString(): String = "$real + ${imaginary}i"

    operator fun plus(other: Complex): Complex =
        Complex(this.real + other.real, this.imaginary + other.imaginary)

    operator fun minus(other: Complex): Complex =
        Complex(this.real - other.real, this.imaginary - other.imaginary)

    operator fun times(other: Complex): Complex =
        Complex(
            this.real * other.real - this.imaginary * other.imaginary,
            this.real * other.imaginary + this.imaginary * other.real
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false
        return kotlin.math.abs(this.real - other.real) < EPS &&
                kotlin.math.abs(this.imaginary - other.imaginary) < EPS
    }

    override fun hashCode(): Int = 31 * real.hashCode() + imaginary.hashCode()

    val abs: Double
        get() = sqrt(real * real + imaginary * imaginary)
}
