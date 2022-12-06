import java.io.File
import java.util.*

fun main() {
	val max = TreeSet<Int>()
	var current = 0
	File("input/1.txt").useLines { lines -> (lines + sequenceOf("")).forEach {
		if (it.isBlank()) {
			max.add(current)
			if (max.size > 3) max.pollFirst()
			current = 0
		} else current += it.toInt()
	} }
	println(max.sum())
}