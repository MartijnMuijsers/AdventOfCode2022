import java.io.File

fun main() {
	var score = 0
	File("input/2.txt").forEachLine {
		val op1 = it[0] - 'A'
		val op2 = it[2] - 'X'
		score += op2 * 3 + 1 + when (op2) {
			0 -> (op1 + 2) % 3
			1 -> op1
			2 -> (op1 + 1) % 3
			else -> throw IllegalStateException()
		}
	}
	println(score)
}