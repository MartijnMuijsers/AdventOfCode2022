import java.io.File
import java.util.*

fun main() {
	val stacks = Array<Deque<Char>>(9) { ArrayDeque(1) }
	var setup = true
	File("input/5.txt").forEachLine { line ->
		if (line.isBlank()) return@forEachLine
		if (setup) {
			if (line[1] == '1') {
				setup = false
				return@forEachLine
			}
			stacks.forEachIndexed { i, stack ->
				line[1 + i * 4].takeIf { !it.isWhitespace() }?.let { stack.addFirst(it) }
			}
			return@forEachLine
		}
		val move = line.split(" ").slice(listOf(1, 3, 5)).map { it.toInt() }
		stacks[move[2] - 1].addAll(Array(move[0]) { stacks[move[1] - 1].pollLast() }.apply { reverse() })
	}
	println(stacks.joinToString("") { "${it.last}" })
}