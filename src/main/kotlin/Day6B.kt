import java.io.File
import java.util.*

fun main() {
	val line = File("input/6.txt").readLines()[0]
	println(1 + line.indices.first { it >= 13 && (0..13).map { relative -> line[it - relative] }.toSet().size == 14 })
}