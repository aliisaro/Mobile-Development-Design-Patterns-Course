import app2.Complex
import app2.EPS
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.sqrt

internal class ComplexTest {
    @Test
    fun testConstructor1() {
        val a = Complex(1.0, 2.0)
        assert(((a.real/1.0 - 1.0) < EPS) && ((a.imaginary/2.0 -
                1.0) < EPS))
    }
    @Test
    fun testConstructor2() {
        val a = Complex(1, 2)
        assert((abs(a.real/1.0 - 1.0) < EPS) &&
                (abs(a.imaginary/2.0 - 1.0) < EPS))
    }
    @Test
    fun testEquals1() {
        val a = Complex(1, 2)
        val b = Complex(1, 2)
        assert(a == b)
    }
    @Test
    fun testEquals2() {
        val a = Complex(1, 2)
        val b = Complex(1, 3)
        assert(a != b)
    }
    @Test
    fun testPlus() {
        val a = Complex(1,2)
        val b = Complex(3,4)
        // see https://kotlinlang.org/docs/operator-overloading.html
        assert((a + b) == Complex(4,6))
    }
    @Test
    fun testMinus() {
        val a = Complex(1,2)
        val b = Complex(3,4)
        // see https://kotlinlang.org/docs/operator-overloading.html
        assert((a - b) == Complex(-2,-2))
    }
    @Test
    fun testTimes1() {
        val a = Complex(0,1)
        val b = Complex(0,1)
        // see https://kotlinlang.org/docs/operator-overloading.html
        assert((a * b) == Complex(-1,0))
    }
    @Test
    fun testTimes2() {
        val a = Complex(1,2)
        val b = Complex(3,4)
        // see https://kotlinlang.org/docs/operator-overloading.html
        assert((a * b) == Complex(-5,10))
    }
    @Test
    fun testTimes3() {
        val a = Complex(1,2)
        val b = Complex(1,-2)
        // see https://kotlinlang.org/docs/operator-overloading.html
        assert((a * b) == Complex(5,0))
    }
    @Test
    fun testAbs1() {
        val a = Complex(1,0)
        assert(abs(a.abs - 1.0) < EPS)
    }
    @Test
    fun testAbs2() {
        val a = Complex(1,1)
        assert(abs(a.abs - sqrt(2.0)) < EPS)
    }
}