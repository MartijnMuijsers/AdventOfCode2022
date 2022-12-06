import java.io.File
import java.util.*

fun main() {
	val line = File("input/6.txt").readLines()[0]
	println(1 + line.indices.first { it >= 3 && (0..3).map { relative -> line[it - relative] }.toSet().size == 4 })
}