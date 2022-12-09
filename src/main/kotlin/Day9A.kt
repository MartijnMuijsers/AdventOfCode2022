import java.io.File

fun main() {
	val h = arrayOf(0, 0)
	val t = arrayOf(0, 0)
	val had: MutableSet<Pair<Int, Int>> = hashSetOf(t[0] to t[1])
	File("input/9.txt").forEachLine { line ->
		val split = line.split(" ")
		val relative = if (split[0] in "LU") -1 else 1
		val axis = if (split[0] in "UD") 1 else 0
		repeat (split[1].toInt()) {
			if (h[axis] == t[axis] + relative) {
				t[axis] += relative
				if (h[1 - axis] != t[1 - axis]) t[1 - axis] = h[1 - axis]
				had += t[0] to t[1]
			}
			h[axis] += relative
		}
	}
	println(had.size)
}