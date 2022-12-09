import java.io.File
import kotlin.math.sign

fun main() {
	val p = Array(10) { arrayOf(0, 0) }
	val had: MutableSet<Pair<Int, Int>> = hashSetOf(0 to 0)
	File("input/9.txt").forEachLine { line ->
		val split = line.split(" ")
		repeat (split[1].toInt()) {
			p[0][if (split[0] in "UD") 1 else 0] += if (split[0] in "LU") -1 else 1
			for (i in 0..8) for (d in 0..1) {
				val move = (p[i][d] - p[i + 1][d]) / 2
				p[i + 1][d] += move
				p[i + 1][1 - d] += if (move == 0) 0 else sign((p[i][1 - d] - p[i + 1][1 - d]).toDouble()).toInt()
			}
			had += p[9][0] to p[9][1]
		}
	}
	println(had.size)
}