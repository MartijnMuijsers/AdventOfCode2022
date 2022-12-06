import java.io.File

fun main() {
	var sum = 0
	File("input/3.txt").forEachLine {
		var common = 0L.inv()
		it.chunked(it.length / 2).forEach {
			var content = 0L
			it.forEach { content = content or (1L shl (it - (if (it <= 'Z') 'A' - 26 else 'a'))) }
			common = common and content
		}
		sum += 1 + (0..51).first { common and (1L shl it) != 0L }
	}
	println(sum)
}