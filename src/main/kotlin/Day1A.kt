import java.io.File

fun main() {
	var max = 0
	var current = 0
	File("input/1.txt").forEachLine {
		if (it.isNotBlank()) {
			current += it.toInt()
			max = max.coerceAtLeast(current)
		} else current = 0
	}
	println(max)
}