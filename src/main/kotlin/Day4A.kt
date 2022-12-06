import java.io.File

fun main() {
	println(File("input/4.txt").useLines { it.count {
		val ranges = it.split(",").map { it.split("-").map { it.toInt() } }
		for (i in 0..1)
			if (ranges[i][0] <= ranges[1 - i][0] && ranges[i][1] >= ranges[1 - i][1]) return@count true
		false
	} })
}