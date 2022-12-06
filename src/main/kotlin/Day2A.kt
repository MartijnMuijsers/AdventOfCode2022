import java.io.File

fun main() {
	var score = 0
	File("input/2.txt").forEachLine {
		val op1 = it[0] - 'A'
		val op2 = it[2] - 'X'
		score += op2 + 1 + if (op1 == op2) 3 else if (op2 == (op1 + 1) % 3) 6 else 0
	}
	println(score)
}